package com.khetao.tome.loadbalancer.core;

import com.khetao.tome.loadbalancer.constants.CommonHeaders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultRequestContext;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.RequestData;
import org.springframework.cloud.loadbalancer.core.DelegatingServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 按版本标志匹配
 * @author chenqinhao 2022/8/2
 * @email qhchen96@gmail.com
 */
@Slf4j
public class VersionServiceInstanceListSupplier extends DelegatingServiceInstanceListSupplier {


    public VersionServiceInstanceListSupplier(ServiceInstanceListSupplier delegate) {
        super(delegate);
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        return this.delegate.get();
    }

    @Override
    public Flux<List<ServiceInstance>> get(Request request) {
        String version = getVersion(request);
        if (!StringUtils.hasText(version)) {
            return this.delegate.get(request);
        }
        return this.delegate.get(request)
                .map((serviceInstances) -> this.selectInstance(serviceInstances, version));
    }

    public List<ServiceInstance> selectInstance(List<ServiceInstance> serviceInstances, String version) {
        Iterator iterator = serviceInstances.iterator();
        ServiceInstance serviceInstance;
        do {
            if (!iterator.hasNext()) {
                if (log.isDebugEnabled()) {
                    // 没有找到实例则直接返回
                    log.debug(String.format("Service instance for version: %s not found. Returning all instances returned by delegate.", version));
                }
                return serviceInstances;
            }
            serviceInstance = (ServiceInstance)iterator.next();
        } while(!version.equalsIgnoreCase(serviceInstance.getMetadata().get(CommonHeaders.VERSION)));

        if (log.isDebugEnabled()) {
            log.debug(String.format("Returning the service instance: %s. Found for version: %s", serviceInstance.toString(), version));
        }

        return Collections.singletonList(serviceInstance);
    }

    private String getVersion(Request request) {
        if (request.getContext() instanceof DefaultRequestContext) {
            DefaultRequestContext requestContext = (DefaultRequestContext) request.getContext();
            if (requestContext.getClientRequest() instanceof RequestData) {
                RequestData clientRequest = (RequestData) requestContext.getClientRequest();
                HttpHeaders headers = clientRequest.getHeaders();
                String version = headers.getFirst(CommonHeaders.VERSION);
                return version;
            }
        }
        return null;
    }

}
