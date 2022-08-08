package com.khetao.tome.toolkit.disruptor.consumer;

/**
 * @author chenqinhao 2022/8/4
 * @email qhchen96@gmail.com
 */
public interface QueueConsumerFactory<T> {

    QueueConsumerExecutor<T> create();

    String getName();

}
