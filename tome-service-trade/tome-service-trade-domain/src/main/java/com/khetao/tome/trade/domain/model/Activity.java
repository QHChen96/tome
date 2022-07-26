package com.khetao.tome.trade.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 活动
 * @author chenqinhao 2022/7/26
 * @email qhchen96@gmail.com
 */
@Data
public class Activity {
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动类型
     */
    private Integer activityType;
    /**
     * 活动状态
     */
    private Integer status;
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
}

