package com.khetao.tome.loadbalancer.predicate;

import com.khetao.tome.loadbalancer.constants.CommonHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;

/**
 * 等值匹配匹配
 * @author chenqinhao 2022/8/1
 * @email qhchen96@gmail.com
 */
@RequiredArgsConstructor
public class VersionServiceInstancePredicate implements ServiceInstancePredicate {
    private final String version;

    @Override
    public boolean test(ServiceInstance serviceInstance) {
        String targetVersion = serviceInstance.getMetadata().get(CommonHeaders.VERSION);
        return version.equalsIgnoreCase(targetVersion);
    }

}
