package com.khetao.tome.member.domain.model;

import com.khetao.tome.ddd.AggregateRoot;

import java.time.LocalDate;


public class Member extends AggregateRoot {

    /**
     * 会员id
     */
    private Long id;

    /**
     * 会员名称
     */
    private String name;

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



}
