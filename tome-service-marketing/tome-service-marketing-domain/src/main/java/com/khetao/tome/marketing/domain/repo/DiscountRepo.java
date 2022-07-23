package com.khetao.tome.marketing.domain.repo;

import com.khetao.tome.marketing.domain.model.Discount;
import com.khetao.tome.marketing.domain.model.DiscountItem;

import java.util.Collection;

/**
 * 折扣存储接口
 * @author chenqinhao 2022/7/24
 * @email qhchen96@gmail.com
 */
public interface DiscountRepo {

    void storeDiscount(Discount discount);

    void addDiscountItems(Discount discount, Collection<DiscountItem> discountItems);

    void deleteDiscountItems(Discount discount, Collection<DiscountItem> discountItems);

}
