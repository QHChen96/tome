package com.khetao.tome.trade.dto;

import com.khetao.tome.dto.DTO;
import lombok.Data;

/**
 * @author chenqinhao 2022/7/13
 * @email qhchen96@gmail.com
 */
@Data
public class OrderItemDTO extends DTO {
    private Long orderItemId;
    private Long orderId;
    private Long spuId;
    private Long skuId;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}
