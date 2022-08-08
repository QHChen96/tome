package com.khetao.tome.loadbalancer.config;

import com.khetao.tome.loadbalancer.chooser.VersionLoadBalancer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.reactive.ReactiveLoadBalancer;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

/**
 * @author chenqinhao 2022/8/3
 * @email qhchen96@gmail.com
 */
@Configuration(proxyBeanMethods = false)
@LoadBalancerClients(defaultConfiguration = LoadBalancerAutoConfiguration.VersionLoadBalancerClients.class)
@ConditionalOnProperty(value = "spring.cloud.loadbalancer.enabled", havingValue = "true", matchIfMissing = true)
public class LoadBalancerAutoConfiguration {


    public static class VersionLoadBalancerClients {

//        @Bean
//        public ServiceInstanceListSupplier reactorServiceInstanceLoadBalancer(ServiceInstanceListSupplier delegate) {
//            System.out.println("reactorServiceInstanceLoadBalancer");
//            return new VersionServiceInstanceListSupplier(delegate);
//        }

        @Bean
        @Primary
        public ReactiveLoadBalancer<ServiceInstance> reactorServiceInstanceLoadBalancer(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory) {
            String name = LoadBalancerClientFactory.getName(environment);
            return new VersionLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
        }

    }
}
