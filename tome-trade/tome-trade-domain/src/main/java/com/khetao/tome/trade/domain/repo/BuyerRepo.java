package com.khetao.tome.trade.domain.repo;

import com.khetao.tome.trade.domain.model.Buyer;

/**
 * @author chenqinhao 2022/7/15
 * @email qhchen96@gmail.com
 */
public interface BuyerRepo {

    /**
     * 获取买家基础信息
     * @param buyerId
     * @return
     */
    Buyer getBuyer(Long buyerId);

}
