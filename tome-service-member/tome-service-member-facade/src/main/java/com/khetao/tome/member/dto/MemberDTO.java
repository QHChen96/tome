package com.khetao.tome.member.dto;

import com.khetao.tome.dto.DTO;
import lombok.Data;

/**
 * @author chenqinhao 2022/7/14
 * @email qhchen96@gmail.com
 */
public class MemberDTO extends DTO {
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 会员名称
     */
    private String memberName;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
