package com.khetao.tome.trade.domain.model;

import com.khetao.tome.ddd.valobj.Image;
import com.khetao.tome.ddd.valobj.Money;
import lombok.Data;

/**
 * 售后
 * @author chenqinhao 2022/7/24
 * @email qhchen96@gmail.com
 */
@Data
public class AfterSaleOrderItem {
    private Long itemId;
    private String itemName;
    private Image imageUrl;
    private Money price;
    private Integer appliedCount;
    private Integer returnedCount;
    private Integer refundedCount;
    private Money returnPrice;
    private Long exchangeItemId;
    private String exchangeItemName;
    private String exchangeItemImageUrl;

}
