package com.khetao.tome.product.domain.model;

import com.khetao.tome.ddd.valobj.Image;
import com.khetao.tome.ddd.valobj.Money;
import com.khetao.tome.ddd.valobj.Video;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * 商品
 * @author chenqinhao 2022/7/19
 * @email qhchen96@gmail.com
 */
@Data
public class Item {
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 名称
     */
    private String itemName;
    /**
     * 标题
     */
    private String title;
    /**
     * 子标题
     */
    private String subTitle;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 市场价
     */
    private Money marketPrice;
    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 商品主图
     */
    private List<Image> imageUrls;
    /**
     * 视频视频
     */
    private Video videoUrl;
    /**
     * 货号
     */
    private String articleNumber;
    /**
     * 备注
     */
    private String remark;
    /**
     * 审核状态
     */
    private Integer status;
    /**
     * 预售发货时间间隔
     */
    private Integer preSaleDeliverType;
}
