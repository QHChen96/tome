package com.khetao.tome.toolkit.disruptor.consumer;

import lombok.Data;

/**
 * @author chenqinhao 2022/8/4
 * @email qhchen96@gmail.com
 */
@Data
public abstract class QueueConsumerExecutor<T> implements Runnable {

    private T data;

}
