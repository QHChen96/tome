package com.khetao.tome.marketing.domain.model;

import com.khetao.tome.ddd.EntitySnapshot;
import com.khetao.tome.marketing.domain.repo.DiscountRepo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author chenqinhao 2022/7/23
 * @email qhchen96@gmail.com
 */
@Getter
@Builder
public class Discount extends EntitySnapshot<Discount> {
    private Long discountId;
    private String discountName;
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    private LocalDateTime gmtModify;
    /**
     * 这个需要通过工厂创建出来才有
     */
    private DiscountRepo discountRepo;

    public boolean hasRepo() {
        return discountRepo != null;
    }

    /**
     * 保存改动
     */
    public void store() {
        this.pollute();
        this.save((diff) -> discountRepo.storeDiscount(diff));
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
        Discount snapshot = Discount.builder()
                .discountId(discountId)
                .discountName(discountName)
                .startTime(startTime)
                .endTime(endTime)
                .build();
        return snapshot;
    }

    @Override
    protected Discount diff() {
        Discount _snapshot = this.snapshot;
        // 如果没有快照，说明是一个新建对象, 所以这里可以直接返回
        if (_snapshot == null) {
            return this;
        }
        Discount diffDiscount = Discount.builder().build();
        // 因为discountId是不可变的
        diffDiscount.discountId = _snapshot.getEntityId();
        if (isNeedChange(this.discountName, _snapshot.discountName)) {
            diffDiscount.discountName = this.discountName;
        }
        if (isNeedChange(this.startTime, _snapshot.startTime)) {
            diffDiscount.startTime = this.startTime;
        }
        if (isNeedChange(this.endTime, _snapshot.endTime)) {
            diffDiscount.endTime = this.endTime;
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
