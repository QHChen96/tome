package com.khetao.tome.dto;

import lombok.Data;

/**
 * 手机号
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Phone {
    /**
     * 区码
     */
    private String areaCode;
    /**
     * 手机号
     */
    private String phoneNumber;
}
