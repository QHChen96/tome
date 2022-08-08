package com.khetao.tome.loadbalancer.predicate;

import org.springframework.cloud.client.ServiceInstance;

import java.util.function.Predicate;

/**
 * @author chenqinhao 2022/8/1
 * @email qhchen96@gmail.com
 */
public interface ServiceInstancePredicate extends Predicate<ServiceInstance> {
}
