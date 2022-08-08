package com.khetao.tome.toolkit.disruptor.thread;

import java.util.concurrent.*;

/**
 * @author chenqinhao 2022/8/4
 * @email qhchen96@gmail.com
 */
public class SingletonExecutor extends ThreadPoolExecutor {

    public SingletonExecutor(final ThreadFactory factory) {
        super(1, 1, 0L, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(), factory);
    }

}
