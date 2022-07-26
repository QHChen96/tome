package com.khetao.tome.ddd.valobj;

import lombok.Data;

/**
 * 体积
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Volume {
    /**
     * 长度, 单位mm
     */
    private Long length;
    /**
     * 宽度, 单位mm
     */
    private Long width;
    /**
     * 高度, 单位mm
     */
    private Long height;
}
