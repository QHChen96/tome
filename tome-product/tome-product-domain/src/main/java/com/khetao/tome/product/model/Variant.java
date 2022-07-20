package com.khetao.tome.product.model;

import com.khetao.tome.dto.Money;
import com.khetao.tome.dto.Volume;
import com.khetao.tome.dto.Weight;
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
    private Money price;

    private String sku;
    /**
     * 条形码
     */
    private String barcode;
    /**
     * 重量
     */
    private Weight weight;
    /**
     * 体积
     */
    private Volume volume;
}
