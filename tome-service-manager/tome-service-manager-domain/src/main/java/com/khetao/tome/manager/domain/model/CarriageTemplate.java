package com.khetao.tome.manager.domain.model;

import lombok.Data;

/**
 * 运费模板
 * @author chenqinhao 2022/7/24
 * @email qhchen96@gmail.com
 */
@Data
public class CarriageTemplate {
    private Long templateId;
    private String templateName;
    /**
     * 模板类型, 1=自定义邮费、2=卖家承担邮费
     */
    private Integer templateType;
    /**
     * 计费类型, 1=计件、2=计重
     */
    private Integer costType;

}
