package com.khetao.tome.marketing.domain.factory;

import com.khetao.tome.marketing.domain.model.Discount;

/**
 * 折扣领域对象创建工厂, 由基础设施层实现, 不做更新操作
 * @author chenqinhao 2022/7/24
 * @email qhchen96@gmail.com
 */
public interface DiscountFactory {

    Discount createDiscount();

    /**
     * 获取
     * @param discountId
     * @return
     */
    Discount getDiscount(Long discountId);

}
