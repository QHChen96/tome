package com.khetao.tome.trade.domain.model;

import com.khetao.tome.dto.DTO;

/**
 * 卖家
 * @author chenqinhao 2022/7/15
 * @email qhchen96@gmail.com
 */
public class Buyer extends DTO {

    /**
     * 买家id
     */
    private Long buyerId;

    /**
     * 买家名称
     */
    private String buyerName;

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
}
