package com.khetao.tome.member.dto;

import com.khetao.tome.dto.DTO;

/**
 * @author chenqinhao 2022/7/14
 * @email qhchen96@gmail.com
 */
public class MemberResponse extends DTO {

    private MemberDTO member;

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }
}
