package com.khetao.tome.member.domain.model;

import com.khetao.tome.ddd.AggregateRoot;
import lombok.Data;

import java.time.LocalDate;

/**
 * 会员
 * @author chenqinhao
 */
@Data
public class Member {
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 会员名称
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 等级
     */
    private int level;
    /**
     * 状态
     */
    private int state;
    /**
     * 出生日期
     */
    private LocalDate birthDay;
    /**
     * 性别
     */
    private int sex;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 邮箱
     */
    private String email;



}
