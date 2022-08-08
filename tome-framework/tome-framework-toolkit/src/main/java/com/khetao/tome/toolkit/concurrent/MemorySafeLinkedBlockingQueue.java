package com.khetao.tome.toolkit.concurrent;

import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public class MemorySafeLinkedBlockingQueue<E> extends LinkedBlockingQueue<E> {

    private int maxFreeMemory;

    private Rejector<E> rejector;

    public MemorySafeLinkedBlockingQueue(final int maxFreeMemory) {
        super(Integer.MAX_VALUE);
        this.maxFreeMemory = maxFreeMemory;
        this.rejector = new DiscardPolicy<>();
    }

    public MemorySafeLinkedBlockingQueue(final Collection<? extends E> c,
                                         final int maxFreeMemory) {
        super(c);
        this.maxFreeMemory = maxFreeMemory;
        this.rejector = new DiscardPolicy<>();
    }

    public void setMaxFreeMemory(final int maxFreeMemory) {
        this.maxFreeMemory = maxFreeMemory;
    }

    public int getMaxFreeMemory() {
        return maxFreeMemory;
    }

    public void setRejector(final Rejector<E> rejector) {
        this.rejector = rejector;
    }

    public boolean hasRemainedMemory() {
        return MemoryLimitCalculator.maxAvailable() > maxFreeMemory;
    }

    @Override
    public void put(final E e) throws InterruptedException {
        if (hasRemainedMemory()) {
            super.put(e);
        }
        rejector.reject(e, this);
    }

    @Override
    public boolean offer(final E e, final long timeout, final TimeUnit unit) throws InterruptedException {
        if (!hasRemainedMemory()) {
            rejector.reject(e, this);
            return false;
        }
        return super.offer(e, timeout, unit);
    }

    @Override
    public boolean offer(final E e) {
        if (!hasRemainedMemory()) {
            rejector.reject(e, this);
            return false;
        }
        return super.offer(e);
    }

}
