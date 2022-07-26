package com.khetao.tome.product.domain.model;

import lombok.Data;

import java.util.List;

/**
 * 变体项
 * @author chenqinhao 2022/7/20
 * @email qhchen96@gmail.com
 */
@Data
public class VariantOption {
    private Long variantOptionId;
    private String variantOptionName;
    private List<String> imageUrls;
    private List<String> variantOptionValues;
    private Integer position;
}
