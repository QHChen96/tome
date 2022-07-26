package com.khetao.tome.dto;

import lombok.Data;

/**
 * @author chenqinhao 2022/7/23
 * @email qhchen96@gmail.com
 */
@Data
public class ErrorMessageResponse {
    /**
     * 有错误则会返回,可以作为国际化消息的key
     */
    private String error;
    /**
     * 国际化信息
     */
    private String message;

    /**
     * 请求id TODO 微服务场景考虑在某处设置这个id
     */
    private String requestId;
}
