package com.khetao.tome.manager.domain.model;

import lombok.Data;

/**
 * 管理员
 * @author chenqinhao 2022/7/21
 * @email qhchen96@gmail.com
 */
@Data
public class Manager {
    private Long managerId;
    private String username;
    private String email;
    private String nickname;
    private Integer gender;
}
