package com.khetao.tome.member.facade;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author chenqinhao 2022/7/3
 * @email qhchen96@gmail.com
 */
@FeignClient(name = "member")
public interface MemberFacade {


}
