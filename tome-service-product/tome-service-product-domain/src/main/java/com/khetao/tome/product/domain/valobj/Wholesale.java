package com.khetao.tome.product.domain.valobj;

import com.khetao.tome.ddd.valobj.Money;
import lombok.Data;

/**
 * 批发属性
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Wholesale {
    /**
     * 最小数量
     */
    private Integer min;
    /**
     * 最大数量
     */
    private Integer max;
    /**
     * 价格
     */
    private Money price;
}
