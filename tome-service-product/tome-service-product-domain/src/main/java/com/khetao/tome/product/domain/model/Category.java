package com.khetao.tome.product.domain.model;

import com.khetao.tome.dto.Image;
import lombok.Data;

import java.util.List;

/**
 * 类目
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Category {
    /**
     * 类目id
     */
    private Long categoryId;
    /**
     * 类目名称
     */
    private String categoryName;
    /**
     * 类目图片地址
     */
    private Image imageUrl;
    /**
     * 父类目
     */
    private Category parent;
    /**
     * 分级
     */
    private Integer level;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否有子目录
     */
    private Boolean hasChild;
    /**
     * 类目路径
     */
    private List<String> paths;
}
