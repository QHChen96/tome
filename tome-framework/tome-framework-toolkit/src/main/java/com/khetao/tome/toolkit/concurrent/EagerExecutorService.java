package com.khetao.tome.toolkit.concurrent;

import java.util.concurrent.ExecutorService;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public interface EagerExecutorService extends ExecutorService {

    /**
     * 获取线程数量
     * @return
     */
    int getPoolSize();

    /**
     * 获取近似的活跃线程数
     * @return
     */
    int getActiveCount();

    /**
     * 获取最大线程数
     * @return
     */
    int getMaximumPoolSize();

}
