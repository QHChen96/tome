package com.khetao.tome.manager.domain.model;

import lombok.Data;

/**
 * 快递公司
 * @author chenqinhao 2022/7/24
 * @email qhchen96@gmail.com
 */
@Data
public class ExpressCompany {

    private Long expressCompanyId;
    /**
     * 快递公司编码
     */
    private String expressCompanyCode;
    /**
     * 快递公司名称
     */
    private String expressCompanyName;

    private String description;
}
