package com.khetao.tome.product.domain.type;

/**
 * 数据类型
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
public enum AttributeType {
    INT_TYPE(1),
    ENUM_TYPE(2),
    FLOAT_TYPE(3),
    DATE_TYPE(4),
    TIMESTAMP_TYPE(5);
    Integer type;
    AttributeType(Integer type) {
        this.type = type;
    }
}
