package com.khetao.tome.trade.domain.model;

import com.khetao.tome.ddd.valobj.Money;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 优惠券
 * @author chenqinhao 2022/7/19
 * @email qhchen96@gmail.com
 */
@Data
public class Coupon {
    /**
     * 优惠券id
     */
    private Long couponId;
    /**
     * 折扣金额
     */
    private Money discountAmount;
    /**
     * 满足条件
     */
    private Money conditionPrice;
    /**
     * 优惠券类型
     */
    private Integer couponType;
    /**
     * 有效天数
     */
    private Integer addDays;
    /**
     * 总数量
     */
    private Long batchCount;
    /**
     * 已使用的数量
     */
    private Long usedCount;
    /**
     * 过期类型
     */
    private Integer expireType;
    /**
     * 活动开始时间
     */
    private LocalDateTime activityStartTime;
    /**
     * 活动结束时间
     */
    private LocalDateTime activityEndTime;
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
}
