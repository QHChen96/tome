package com.khetao.tome.toolkit.concurrent;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public interface TaskQueue<E> extends BlockingQueue<E> {

    EagerExecutorService getExecutor();

    void setExecutor(EagerExecutorService service);

    @Override
    default boolean offer(final E e) {
        if (Objects.isNull(getExecutor())) {
            throw new RejectedExecutionException("The task queue does not have executor!");
        }

        int currentPoolThreadSize = getExecutor().getPoolSize();
        if (getExecutor().getActiveCount() < currentPoolThreadSize) {
            return doOffer(e);
        }
        if (currentPoolThreadSize < getExecutor().getMaximumPoolSize()) {
            return false;
        }
        return doOffer(e);
    }

    boolean doOffer(E e);

    default boolean retryOffer(final E o, final long timeout, final TimeUnit unit) throws InterruptedException {
        if (getExecutor().isShutdown()) {
            throw new RejectedExecutionException("Executor is shutdown");
        }
        return offer(o, timeout, unit);
    }
}
