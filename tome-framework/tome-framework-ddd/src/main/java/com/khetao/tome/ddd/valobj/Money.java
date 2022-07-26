package com.khetao.tome.ddd.valobj;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 金额
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Money {
    private BigDecimal amount;
}
