package com.khetao.tome.toolkit.concurrent;

import java.util.Collection;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public class MemorySafeTaskQueue<R extends Runnable> extends MemorySafeLinkedBlockingQueue<Runnable> implements TaskQueue<Runnable> {

    private EagerExecutorService executor;

    public MemorySafeTaskQueue(final int maxFreeMemory) {
        super(maxFreeMemory);
    }


    public MemorySafeTaskQueue(final Collection<? extends Runnable> c, final int maxFreeMemory) {
        super(c, maxFreeMemory);
    }

    @Override
    public EagerExecutorService getExecutor() {
        return executor;
    }

    @Override
    public void setExecutor(EagerExecutorService executor) {
        this.executor = executor;
    }

    @Override
    public boolean doOffer(Runnable runnable) {
        return super.offer(runnable);
    }
}
