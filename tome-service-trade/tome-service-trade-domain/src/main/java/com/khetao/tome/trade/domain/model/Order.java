package com.khetao.tome.trade.domain.model;

import com.khetao.tome.ddd.valobj.Address;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单
 * @author chenqinhao 2022/7/15
 * @email qhchen96@gmail.com
 */
@Data
public class Order {
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单编号
     */
    private String orderSn;
    /**
     * 外部订单编号
     */
    private String outerOrderSn;
    /**
     * 标题
     */
    private String title;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * 买家id
     */
    private Long buyerId;
    /**
     * 卖家id
     */
    private Long sellerId;
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
     * 总运费
     */
    private BigDecimal totalFreightAmount;
    /**
     * 总数量
     */
    private Integer totalQuantity;
    /**
     * 总商品数
     */
    private Integer totalUniqueItems;
    /**
     * 下单时间
     */
    private LocalDateTime orderTime;
    /**
     * 取消时间
     */
    private LocalDateTime cancelledTime;
    /**
     * 开始处理时间
     */
    private LocalDateTime processedTime;
    /**
     * 支付时间
     */
    private LocalDateTime paidTime;
    /**
     * 发货时间
     */
    private LocalDateTime deliveredTime;
    /**
     * 收货时间
     */
    private LocalDateTime receivedTime;
    /**
     * 完成时间
     */
    private LocalDateTime completedTime;
    /**
     * 过期时间
     */
    private LocalDateTime expiredTime;
    /**
     * 买家备注
     */
    private String buyerNote;
    /**
     * 卖家备注
     */
    private String sellerNote;
    /**
     * 来源类型
     */
    private String sourceType;
    /**
     * 订单来源IP
     */
    private String sourceIp;
    /**
     * 是否测试订单
     */
    private boolean test;
    /**
     * 是否包含税费
     */
    private boolean taxIncluded;
    /**
     * 支付方式: 货到付款、在线支付
     */
    private Integer payType;
    /**
     * 订单类型
     */
    private Integer orderType;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 地址
     */
    private Address address;
    /**
     * 详细地址
     */
    private String addressDetail;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 用户名称
     */
    private String userName;

}
