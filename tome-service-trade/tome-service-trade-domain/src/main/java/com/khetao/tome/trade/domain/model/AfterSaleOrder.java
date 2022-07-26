package com.khetao.tome.trade.domain.model;

import lombok.Data;

/**
 * 退款订单
 * @author chenqinhao 2022/7/19
 * @email qhchen96@gmail.com
 */
@Data
public class AfterSaleOrder {
    private Long afterSaleOrderId;
    private Integer returnType;
    private Integer reasonId;
    private String reason;

    private Long orderId;
    /**
     * 退货状态
     */
    private Integer status;
    /**
     * 退款类型
     */
    private Integer refundType;
}
