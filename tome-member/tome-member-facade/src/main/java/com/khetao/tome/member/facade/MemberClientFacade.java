package com.khetao.tome.member.facade;

import com.khetao.tome.dto.SingleResponse;
import com.khetao.tome.member.dto.MemberDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenqinhao 2022/7/3
 * @email qhchen96@gmail.com
 */
@FeignClient(name = "member-provider")
public interface MemberClientFacade {

    @GetMapping("/member/{memberId}")
    SingleResponse<MemberDTO> getMember(@PathVariable("memberId") Long memberId);

}
