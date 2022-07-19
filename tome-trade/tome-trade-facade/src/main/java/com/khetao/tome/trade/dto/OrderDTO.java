package com.khetao.tome.trade.dto;

import com.khetao.tome.dto.DTO;
import lombok.*;


import java.util.Collection;

/**
 * @author chenqinhao 2022/7/13
 * @email qhchen96@gmail.com
 */
public class OrderDTO extends DTO {
    private Long orderId;
    private String orderSn;
    private Long memberId;
    private Long merchantId;

    private String buyerName;
    private Collection<OrderItemDTO> orderItems;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Collection<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
}
