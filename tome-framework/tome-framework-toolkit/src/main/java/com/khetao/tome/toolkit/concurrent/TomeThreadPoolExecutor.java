package com.khetao.tome.toolkit.concurrent;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public class TomeThreadPoolExecutor extends ThreadPoolExecutor implements EagerExecutorService {
    public TomeThreadPoolExecutor(final int corePoolSize,
                                  final int maximumPoolSize,
                                  final long keepAliveTime,
                                  final TimeUnit unit,
                                  final TaskQueue<Runnable> workQueue,
                                  final ThreadFactory threadFactory,
                                  final RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        workQueue.setExecutor(this);
    }

    @Override
    public void execute(Runnable command) {
        if (Objects.isNull(command)) {
            throw new NullPointerException();
        }
        try {
            super.execute(command);
        } catch (RejectedExecutionException e) {
            // retry to offer the task into queue.
            final TaskQueue<Runnable> queue = (TaskQueue<Runnable>) super.getQueue();
            try {
                if (!queue.retryOffer(command, 0, TimeUnit.MILLISECONDS)) {
                    throw new RejectedExecutionException("Queue capacity is full.", e);
                }
            } catch (InterruptedException t) {
                throw new RejectedExecutionException(t);
            }
        }
    }
}
