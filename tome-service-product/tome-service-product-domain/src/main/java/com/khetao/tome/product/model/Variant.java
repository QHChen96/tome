package com.khetao.tome.product.model;

import com.khetao.tome.ddd.valobj.Money;
import com.khetao.tome.ddd.valobj.Stock;
import com.khetao.tome.ddd.valobj.Volume;
import com.khetao.tome.ddd.valobj.Weight;
import lombok.Data;

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
    /**
     * 市场价
     */
    private Money marketPrice;

    private String skucode;
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
    /**
     * 可售库存
     */
    private Stock stock;
}
