package com.khetao.tome.manager.domain.model;

import lombok.Data;

/**
 * 权限
 * @author chenqinhao 2022/7/21
 * @email qhchen96@gmail.com
 */
@Data
public class Permit {
    private Long permitId;
    private String permitName;
    private String permitCode;
}
