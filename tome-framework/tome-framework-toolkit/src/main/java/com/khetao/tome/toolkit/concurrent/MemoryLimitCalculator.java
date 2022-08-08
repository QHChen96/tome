package com.khetao.tome.toolkit.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public class MemoryLimitCalculator {

    private static volatile long maxAvailable;

    private static final AtomicBoolean REFRESH_STARTED = new AtomicBoolean(false);

    private static void checkAndScheduleRefresh() {
        if (!REFRESH_STARTED.get()) {
            refresh();
            if (REFRESH_STARTED.compareAndSet(false, true)) {
                ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, TomeThreadFactory.create("Tome-Memory-Calculator-", false));
                scheduledExecutorService.scheduleWithFixedDelay(MemoryLimitCalculator::refresh, 50, 50, TimeUnit.MICROSECONDS);
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    REFRESH_STARTED.set(false);
                    scheduledExecutorService.shutdown();
                }));
            }
        }
    }

    private static void refresh() {
        maxAvailable = Runtime.getRuntime().freeMemory();
    }

    public static long maxAvailable() {
        checkAndScheduleRefresh();
        return maxAvailable;
    }

    public static long calculate(final float percentage) {
        if (percentage <= 0 || percentage > 1) {
            throw new IllegalArgumentException();
        }
        checkAndScheduleRefresh();
        return (long) (maxAvailable() * percentage);
    }

    public static long defaultLimit() {
        checkAndScheduleRefresh();
        return  (long) (maxAvailable() * 0.8);
    }

}
