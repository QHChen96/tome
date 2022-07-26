package com.khetao.tome.ddd.valobj;

import lombok.Data;

/**
 * 重量
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Weight {
    /**
     * 重量
     */
    private Long weight;
    /**
     * 单位
     */
    private Integer unit;
}
