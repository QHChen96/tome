package com.khetao.tome.trade.domain.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单明细
 * @author chenqinhao 2022/7/15
 * @email qhchen96@gmail.com
 */

@Data
public class OrderItem {
    /**
     * 订单明细id
     */
    private Long orderItemId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 商品名称
     */
    private String itemName;
    /**
     * sku
     */
    private Long skuId;
    /**
     * sku名称
     */
    private String skuName;
    /**
     * 税费
     */
    private BigDecimal taxTotalAmount;
    /**
     * 免税额
     */
    private BigDecimal taxExemptTotalAmount;
    /**
     * 关税
     */
    private BigDecimal dutiesTotalAmount;
    /**
     * 折扣额
     */
    private BigDecimal discountAmount;
    /**
     * 退款总额
     */
    private BigDecimal returnsAmount;
    /**
     * 总金额
     */
    private BigDecimal totalPrice;
    /**
     * 支付金额
     */
    private BigDecimal totalPaymentPrice;
    /**
     * 折扣比例
     */
    private BigDecimal discountPercentage;
    /**
     * 运费
     */
    private BigDecimal freightAmount;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 发货数量
     */
    private Integer fulfilledQuantity;
    /**
     * 是否需要发货
     */
    private boolean requiresShipping;
    /**
     * 是否包含税费
     */
    private boolean taxIncluded;
}
