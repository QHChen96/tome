package com.khetao.tome.trade.dto;

import com.khetao.tome.dto.DTO;
import lombok.Data;

/**
 * @author chenqinhao 2022/7/13
 * @email qhchen96@gmail.com
 */
@Data
public class OrderResponse extends DTO {

    private OrderDTO order;

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

}
