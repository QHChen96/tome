package com.khetao.tome.product.domain.model;

import com.khetao.tome.product.domain.type.AttributeInputType;
import com.khetao.tome.product.domain.type.AttributeType;
import lombok.Data;

import java.util.List;

/**
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Attribute {
    private Long attributeId;
    /**
     * 属性名称
     */
    private String attributeName;
    /**
     * 属性类型
     */
    private AttributeType attributeType;
    /**
     * 输入类型
     */
    private AttributeInputType inputType;
    /**
     * 类目id
     */
    private Long categoryId;
    /**
     * 属性项
     */
    private List<AttributeOption> options;
}
