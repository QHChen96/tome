package com.khetao.tome.marketing.model;

import com.khetao.tome.marketing.type.ShopStatus;
import lombok.Data;

/**
 * 店铺
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Shop {
    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺logo
     */
    private String logoImageUrl;

    /**
     * 店铺状态
     */
    private ShopStatus status;

    /**
     * 商家id
     */
    private Long merchantId;

    /**
     * 描述
     */
    private String description;

}
