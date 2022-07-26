package com.khetao.tome.product.domain.model;

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
    private Long stock;
}
