package com.khetao.tome.member.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenqinhao 2022/7/8
 * @email qhchen96@gmail.com
 */
@EnableDiscoveryClient
@SpringBootApplication(proxyBeanMethods = false)
public class MemberProviderApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MemberProviderApplication.class, args);
    }

}
