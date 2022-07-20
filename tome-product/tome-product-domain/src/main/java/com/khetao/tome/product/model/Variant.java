package com.khetao.tome.product.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * sku变体
 * @author chenqinhao 2022/7/19
 * @email qhchen96@gmail.com
 */
@Data
public class Variant {

    private Long variantId;

    private Long itemId;

    private String variantName;

    private List<Integer> optionIndexes;
    /**
     * 价格
     */
    private BigDecimal price;

    private String sku;

    private String barcode;


}
