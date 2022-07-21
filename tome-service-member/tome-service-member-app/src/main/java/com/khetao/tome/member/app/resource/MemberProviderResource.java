package com.khetao.tome.member.app.resource;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.khetao.tome.dto.SingleResponse;
import com.khetao.tome.member.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenqinhao 2022/7/8
 * @email qhchen96@gmail.com
 */
@RestController
public class MemberProviderResource {

    private static final Logger logger = LoggerFactory.getLogger(MemberProviderResource.class);

    @GetMapping("/member/{memberId}")
    @SentinelResource(blockHandler = "blockHandleGetMember")
    public SingleResponse<MemberDTO> getMember(@PathVariable Long memberId) {
        MemberDTO member = new MemberDTO();
        member.setMemberId(memberId);
        member.setMemberName("member" + memberId);
        return SingleResponse.success(member);
    }

    public SingleResponse<MemberDTO> blockHandleGetMember(Long memberId, BlockException ex) {
        logger.error("获取用户触发降级");
        MemberDTO member = new MemberDTO();
        member.setMemberId(memberId);
        member.setMemberName("降级用户");
        return SingleResponse.success(member);
    }



}
