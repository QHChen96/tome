package com.khetao.tome.product.domain.type;

/**
 * 商品状态
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
public enum ItemStatus {
    /**
     * 正常
     */
    NORMAL(1),
    /**
     * 删除
     */
    DELETED(2),
    /**
     * 禁用
     */
    BANNED(3),
    /**
     * 下架
     */
    UN_LIST(4);
    Integer status;
    ItemStatus(Integer status) {
        this.status = status;
    }
}
