package com.khetao.tome.marketing.domain.model;

import com.khetao.tome.ddd.valobj.Money;
import com.khetao.tome.ddd.valobj.Stock;
import lombok.Data;

/**
 * @author chenqinhao 2022/7/24
 * @email qhchen96@gmail.com
 */
@Data
public class DiscountItem {
    private Long itemId;
    private Long variantId;
    /**
     * 折扣价
     */
    private Money promotionPrice;
    /**
     * 库存限制
     */
    private Integer promotionStock;

    /**
     * 数量限制, 如果不限制数量则输入0
     */
    private Integer purchaseLimit;

}
