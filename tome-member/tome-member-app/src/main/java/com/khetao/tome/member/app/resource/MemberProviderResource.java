package com.khetao.tome.member.app.resource;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.khetao.tome.member.dto.MemberDTO;
import com.khetao.tome.member.dto.MemberResponse;
import com.khetao.tome.member.facade.MemberClientFacade;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenqinhao 2022/7/8
 * @email qhchen96@gmail.com
 */
@RestController
public class MemberProviderResource {

    private static final Logger logger = LoggerFactory.getLogger(MemberProviderResource.class);

    @GetMapping("/member/{memberId}")
    public MemberResponse getMember(@PathVariable Long memberId) {
        MemberResponse response = new MemberResponse();
        MemberDTO member = new MemberDTO();
        member.setMemberId(memberId);
        member.setMemberName("member" + memberId);
        response.setMember(member);
        return response;
    }

}
