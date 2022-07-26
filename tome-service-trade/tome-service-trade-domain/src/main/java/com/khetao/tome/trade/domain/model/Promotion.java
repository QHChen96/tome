package com.khetao.tome.trade.domain.model;

import com.khetao.tome.ddd.valobj.Money;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 促销活动
 * @author chenqinhao 2022/7/19
 * @email qhchen96@gmail.com
 */
@Data
public class Promotion {
    private Long promotionId;
    private String promotionName;
    /**
     * 促销价格
     */
    private Money promotionPrice;
    private Long itemId;
    private Long variantId;
    /**
     * 促销开始时间
     */
    private LocalDateTime startTime;
    /**
     * 促销结束时间
     */
    private LocalDateTime endTime;
    /**
     * 促销范围
     */
    private Integer bound;
    /**
     * 会员等级范围
     */
    private Integer memberLevelBound;
    /**
     * 广告词
     */
    private String slogan;
    /**
     * 最小购买数量
     */
    private Integer buyLimitMin;
    /**
     * 最大购买数量
     */
    private Integer buyLimitMax;
}
