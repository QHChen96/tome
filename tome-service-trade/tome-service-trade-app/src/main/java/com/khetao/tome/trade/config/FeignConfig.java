package com.khetao.tome.trade.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author chenqinhao 2022/7/16
 * @email qhchen96@gmail.com
 */
@Configuration
@Profile("!test")
@EnableFeignClients(basePackages = {
        "com.khetao.tome.member.facade"
})
public class FeignConfig {



}
