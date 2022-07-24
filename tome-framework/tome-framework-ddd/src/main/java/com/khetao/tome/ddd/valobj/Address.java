package com.khetao.tome.ddd.valobj;

import lombok.Data;

/**
 * 地址
 * @author chenqinhao 2022/7/24
 * @email qhchen96@gmail.com
 */
@Data
public class Address {
    /**
     * 国家
     */
    private Long countryCode;
    private String countryName;
    /**
     * 省份
     */
    private Long provinceCode;
    private String provinceName;
    /**
     * 城市
     */
    private Long cityCode;
    private String cityName;
    /**
     * 区域
     */
    private Long areaCode;
    private String areaName;
}
