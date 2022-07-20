package com.khetao.tome.payment.app;

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
@SpringBootApplication
@ComponentScan(basePackages = {
    "com.khetao.tome",
})
public class ShoppingcartProviderApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingcartProviderApplication.class, args);
    }

}
