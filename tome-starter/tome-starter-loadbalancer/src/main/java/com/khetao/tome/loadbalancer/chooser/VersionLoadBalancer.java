package com.khetao.tome.loadbalancer.chooser;

import com.khetao.tome.loadbalancer.constants.CommonHeaders;
import com.khetao.tome.loadbalancer.predicate.VersionServiceInstancePredicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.cloud.loadbalancer.core.*;
import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 全链路标签匹配方案
 * @author chenqinhao 2022/8/1
 * @email qhchen96@gmail.com
 */
@Slf4j
public class VersionLoadBalancer implements ReactorServiceInstanceLoadBalancer {

    final String serviceId;
    ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;
    final AtomicInteger position;

    public VersionLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider, String serviceId) {
        this.serviceId = serviceId;
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
        this.position = new AtomicInteger((new Random()).nextInt(1000));
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = (ServiceInstanceListSupplier)this.serviceInstanceListSupplierProvider.getIfAvailable(NoopServiceInstanceListSupplier::new);
        return supplier.get(request).next().map((serviceInstances) -> {
            return this.processInstanceResponse(supplier, serviceInstances, request);
        });
    }

    private Response<ServiceInstance> processInstanceResponse(ServiceInstanceListSupplier supplier, List<ServiceInstance> serviceInstances, Request request) {
        Response<ServiceInstance> serviceInstanceResponse = this.getInstanceResponse(serviceInstances, request);
        if (supplier instanceof SelectedInstanceCallback && serviceInstanceResponse.hasServer()) {
            ((SelectedInstanceCallback)supplier).selectedServiceInstance((ServiceInstance)serviceInstanceResponse.getServer());
        }
        return serviceInstanceResponse;
    }

    private Response<ServiceInstance> getInstanceResponse(List<ServiceInstance> instances, Request request) {
        if (instances.isEmpty()) {
            if (log.isWarnEnabled()) {
                log.warn("No servers available for service: " + this.serviceId);
            }
            return new EmptyResponse();
        }
        DefaultRequestContext requestContext = (DefaultRequestContext) request.getContext();
        RequestData clientRequest = (RequestData) requestContext.getClientRequest();
        HttpHeaders headers = clientRequest.getHeaders();
        String version = headers.getFirst(CommonHeaders.VERSION);
        List<ServiceInstance> candidateInstances = null;
        if (StringUtils.hasText(version)) {
            // 先按标签进行匹配, 后续也可考虑本地IP地址匹配,网段匹配,压测标签之类的功能。
            Stream<ServiceInstance> instanceStream = instances
                    .stream()
                    .filter(new VersionServiceInstancePredicate(version));
            candidateInstances = instanceStream.collect(Collectors.toList());
        }
        // 这一步是为了，如果按标签筛选不出实例，就放弃筛选, 针对一些特殊的业务后续也可以加入一个强标志, 筛选不到就进行报错
        if (CollectionUtils.isEmpty(candidateInstances)) {
            candidateInstances = instances;
        }
        // 避免超出int范围。
        int pos = this.position.incrementAndGet() & Integer.MAX_VALUE;
        // 如果有多个实例，这里用轮询来负载均衡，避免流量倾斜。
        ServiceInstance instance = (ServiceInstance) candidateInstances.get(pos % instances.size());
        return new DefaultResponse(instance);
    }

}
