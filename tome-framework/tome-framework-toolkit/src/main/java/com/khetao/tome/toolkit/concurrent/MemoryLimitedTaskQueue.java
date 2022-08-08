package com.khetao.tome.toolkit.concurrent;

import java.lang.instrument.Instrumentation;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public class MemoryLimitedTaskQueue<R extends Runnable> extends MemoryLimitedLinkedBlockingQueue<Runnable> implements TaskQueue<Runnable> {

    private EagerExecutorService executor;

    public MemoryLimitedTaskQueue(final Instrumentation inst) {
        super(inst);
    }

    public MemoryLimitedTaskQueue(final long memoryLimit, final Instrumentation inst) {
        super(memoryLimit, inst);
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
