package com.khetao.tome.ddd;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 快照对象, 用来存储实体的时候,避免全量更新字段
 * @author chenqinhao 2022/7/24
 * @email qhchen96@gmail.com
 */
public abstract class EntitySnapshot<T extends EntitySnapshot> implements IdEntity {

    /**
     * 快照
     */
    protected T snapshot;

    /**
     * 版本号
     */
    private int _version;

    /**
     * 执行快照, 这个方法不需要考虑深拷贝的问题
     */
    protected abstract T createSnapshot();

    /**
     * 对比
     * @return 返回一个包含修改的字段的对象
     */
    protected abstract T diff();

    /**
     * 执行快照
     */
    protected void snapshot() {
        // 将最新的值设置为快照, 这样就能保存每次的快照对象
        T snapshotEntity = createSnapshot();
        snapshotEntity.snapshot = snapshot;
        this.snapshot = snapshotEntity;
    }

    /**
     * 修改实体内容
     * @param saveFunc
     */
    public void saveAndSnapshot(Consumer<T> saveFunc) {
        if (save(saveFunc)) {
            snapshot();
        }
    }

    public boolean save(Consumer<T> saveFunc) {
        if (isChange()) {
            T diff = diff();
            // 执行具体的修改方法
            saveFunc.accept(diff);
            // 维持id的值
            if (diff.getEntityId() != null) {
                this.setEntityId(diff.getEntityId());
            }
            return true;
        }
        return false;
    }

    public int version() {
        return this._version;
    }

    /**
     * 只有版本变化了才视为可以更新
     */
    public void pollute() {
        this._version++;
    }

    /**
     * 检查版本号
     * @return
     */
    public boolean isChange() {
        if (snapshot == null) {
            return true;
        }
        return this._version != snapshot.version();
    }

    /**
     * 判断是否需要修改
     * @param fieldA
     * @param fieldB
     * @return
     */
    public boolean isNeedChange(Object fieldA, Object fieldB) {
        if (fieldA == null && fieldB == null) {
            return false;
        }
        if (fieldA == null || fieldB == null) {
            return true;
        }
        if (!fieldA.getClass().equals(fieldB.getClass())) {
            return false;
        }
        if (fieldA instanceof Comparable) {
            return ((Comparable)fieldA).compareTo(fieldB) != 0;
        }
        return !fieldA.equals(fieldB);
    }


}
