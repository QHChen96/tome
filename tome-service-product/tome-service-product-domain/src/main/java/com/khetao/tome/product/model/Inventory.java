package com.khetao.tome.product.model;

import com.khetao.tome.ddd.valobj.Stock;
import lombok.Data;

/**
 * 库存
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Inventory {
    private Long inventoryId;
    private Long itemId;
    private Long variantId;
    /**
     * 可售库存
     */
    private Stock saleStock;
    /**
     * 订单预留库存
     */
    private Stock orderBookingStock;
    /**
     * 锁定库存
     */
    private Stock reservedStock;
    /**
     * 总库存
     */
    private Stock totalStock;
}


