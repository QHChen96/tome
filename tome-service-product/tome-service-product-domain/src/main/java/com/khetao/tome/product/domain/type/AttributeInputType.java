package com.khetao.tome.product.domain.type;

/**
 * 输入类型
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
public enum AttributeInputType {
    /**
     * 文本
     */
    TEXT_FILED(1),
    /**
     * 下拉选择
     */
    COMBO_BOX(2),
    /**
     * 多选
     */
    MULTIPLE_SELECT(3),
    /**
     * 多选下拉框
     */
    MULTIPLE_SELECT_COMBO_BOX(4);

    Integer inputType;
    AttributeInputType(Integer inputType) {
        this.inputType = inputType;
    }
}
