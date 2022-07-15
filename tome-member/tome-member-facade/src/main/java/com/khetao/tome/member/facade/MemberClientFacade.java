package com.khetao.tome.member.facade;

import com.khetao.tome.member.dto.MemberResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * @author chenqinhao 2022/7/3
 * @email qhchen96@gmail.com
 */
@FeignClient(name = "member-provider")
public interface MemberClientFacade {

    @GetMapping("/member/{memberId}")
    MemberResponse getMember(@PathVariable("memberId") Long memberId);


}
