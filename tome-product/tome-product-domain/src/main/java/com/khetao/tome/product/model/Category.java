package com.khetao.tome.product.model;

import lombok.Data;

import java.util.List;

/**
 * 类目
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class Category {
    private Long categoryId;
    private String categoryName;
    private String imageUrl;
    private String pid;
    private Integer level;
    private Integer sort;
    private Boolean hasChild;
    private List<String> paths;
}
