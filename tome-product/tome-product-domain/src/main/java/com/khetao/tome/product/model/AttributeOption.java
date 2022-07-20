package com.khetao.tome.product.model;

import lombok.Data;

/**
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class AttributeOption {
    /**
     * 属性值
     */
    private String value;
    /**
     * 排序权重
     */
    private Integer sort;
}
