package com.khetao.tome.toolkit.concurrent;

import java.lang.instrument.Instrumentation;
import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public class MemoryLimitedLinkedBlockingQueue<E> extends LinkedBlockingQueue<E> {

    private final MemoryLimiter memoryLimiter;

    public MemoryLimitedLinkedBlockingQueue(final Instrumentation inst) {
        this(Integer.MAX_VALUE, inst);
    }

    public MemoryLimitedLinkedBlockingQueue(final long memoryLimit, final Instrumentation inst) {
        super(Integer.MAX_VALUE);
        this.memoryLimiter = new MemoryLimiter(memoryLimit, inst);
    }

    public MemoryLimitedLinkedBlockingQueue(final Collection<? extends E> c, final long memoryLimit, final Instrumentation inst) {
        super(c);
        this.memoryLimiter = new MemoryLimiter(memoryLimit, inst);
    }

    public void setMemoryLimit(final long memoryLimit) {
        memoryLimiter.setMemoryLimit(memoryLimit);
    }

    public long getMemoryLimit() {
        return memoryLimiter.getMemoryLimit();
    }

    public long getCurrentMemory() {
        return memoryLimiter.getCurrentMemory();
    }

    public long getCurrentRemainMemory() {
        return memoryLimiter.getCurrentRemainMemory();
    }

    @Override
    public void put(final E e) throws InterruptedException {
        memoryLimiter.acquireInterruptibly(e);
        super.put(e);
    }

    @Override
    public boolean offer(final E e, final long timeout, final TimeUnit unit) throws InterruptedException {
        return memoryLimiter.acquire(e, timeout, unit) && super.offer(e, timeout, unit);
    }

    @Override
    public boolean offer(final E e) {
        return memoryLimiter.acquire(e) && super.offer(e);
    }

    @Override
    public E take() throws InterruptedException {
        final E e = super.take();
        memoryLimiter.releaseInterruptibly(e);
        return e;
    }

    @Override
    public E poll(final long timeout, final TimeUnit unit) throws InterruptedException {
        final E e = super.poll(timeout, unit);
        memoryLimiter.releaseInterruptibly(e, timeout, unit);
        return e;
    }

    @Override
    public E poll() {
        final E e = super.poll();
        memoryLimiter.release(e);
        return e;
    }

    @Override
    public boolean remove(final Object o) {
        final boolean success = super.remove(o);
        if (success) {
            memoryLimiter.release(o);
        }
        return success;
    }

    @Override
    public void clear() {
        super.clear();
        memoryLimiter.reset();
    }

}
