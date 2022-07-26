package com.khetao.tome.manager.domain.model;

import lombok.Data;

/**
 * 角色
 * @author chenqinhao 2022/7/21
 * @email qhchen96@gmail.com
 */
@Data
public class Role {
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
}
