package com.khetao.tome.product.model;

import lombok.Data;

/**
 * 品牌
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Brand {
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * logo 图片地址
     */
    private String logoImageUrl;
    /**
     * 详情
     */
    private String description;
}
