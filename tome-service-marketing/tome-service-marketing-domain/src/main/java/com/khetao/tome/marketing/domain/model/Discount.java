package com.khetao.tome.marketing.domain.model;

import com.khetao.tome.ddd.EntitySnapshot;
import com.khetao.tome.marketing.domain.repo.DiscountRepo;
import lombok.Data;

import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author chenqinhao 2022/7/23
 * @email qhchen96@gmail.com
 */
@Data
public class Discount extends EntitySnapshot<Discount> {
    private Long discountId;
    private String discountName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModify;
    /**
     * 这个需要通过工厂创建出来才有
     */
    private DiscountRepo discountRepo;

    // TODO 考虑是否需要创建一个快照, 用来做更新操作
    public boolean hasRepo() {
        return discountRepo != null;
    }

    /**
     * 保存改动
     */
    public void store() {
        this.saveAndSnapshot((diff) -> discountRepo.storeDiscount(diff));
    }

    /**
     * 添加折扣商品
     * @param discount
     * @param discountItems
     */
    protected void addDiscountItems(Discount discount, Collection<DiscountItem> discountItems) {
        if (!hasRepo()) {
            return;
        }
        discountRepo.addDiscountItems(discount, discountItems);
    }

    /**
     * 删除折扣商品
     * @param discount
     * @param discountItems
     */
    protected void deleteDiscountItem(Discount discount, Collection<DiscountItem> discountItems) {
        if (!hasRepo()) {
            return;
        }
        discountRepo.deleteDiscountItems(discount, discountItems);
    }

    @Override
    protected Discount createSnapshot() {
        Discount snapshot = new Discount();
        snapshot.setDiscountId(discountId);
        snapshot.setDiscountName(discountName);
        snapshot.setStartTime(startTime);
        snapshot.setEndTime(endTime);
        return snapshot;
    }

    @Override
    protected Discount diff() {
        Discount _snapshot = this.snapshot;
        // 如果没有快照，说明是一个新建对象, 所以这里可以直接返回
        if (_snapshot == null) {
            return this;
        }
        Discount diffDiscount = new Discount();
        // 因为discountId是不可变的
        diffDiscount.setDiscountId(_snapshot.getEntityId());
        if (isNeedChange(diffDiscount.discountName, _snapshot.discountName)) {
            diffDiscount.setDiscountName(diffDiscount.discountName);
        }
        if (isNeedChange(diffDiscount.startTime, _snapshot.startTime)) {
            diffDiscount.setStartTime(diffDiscount.startTime);
        }
        if (isNeedChange(diffDiscount.endTime, _snapshot.endTime)) {
            diffDiscount.setEndTime(diffDiscount.endTime);
        }
        return diffDiscount;
    }


    @Override
    public Long getEntityId() {
        return this.discountId;
    }

    @Override
    public void setEntityId(Long entityId) {
        this.discountId = entityId;
    }
}
