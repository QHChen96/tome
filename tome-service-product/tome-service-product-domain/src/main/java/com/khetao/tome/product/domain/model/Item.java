package com.khetao.tome.product.domain.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品
 * @author chenqinhao 2022/7/19
 * @email qhchen96@gmail.com
 */
@Data
public class Item {
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 名称
     */
    private String itemName;
    /**
     * 标题
     */
    private String title;
    /**
     * 子标题
     */
    private String subTitle;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 分类id
     */
    private Long categoryId;


}
