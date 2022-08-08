package com.khetao.tome.toolkit.disruptor.consumer;

import com.khetao.tome.toolkit.disruptor.event.EventMessage;
import com.khetao.tome.toolkit.disruptor.event.OrderlyEventMessage;
import com.khetao.tome.toolkit.disruptor.thread.OrderlyExecutor;
import com.lmax.disruptor.WorkHandler;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chenqinhao 2022/8/4
 * @email qhchen96@gmail.com
 */
public class QueueConsumer<T> implements WorkHandler<EventMessage<T>> {

    private final OrderlyExecutor executor;

    private final QueueConsumerFactory<T> factory;

    public QueueConsumer(final OrderlyExecutor executor, final QueueConsumerFactory<T> factory) {
        this.executor = executor;
        this.factory = factory;
    }

    @Override
    public void onEvent(EventMessage<T> message) throws Exception {
        if (message != null) {
            ThreadPoolExecutor executor = orderly(message);
            QueueConsumerExecutor<T> queueConsumerExecutor = factory.create();
            queueConsumerExecutor.setData(message.getData());
            message.setData(null);
            executor.execute(queueConsumerExecutor);
        }
    }

    public ThreadPoolExecutor orderly(final EventMessage<T> message) {
        if (message instanceof OrderlyEventMessage && !isEmpty(((OrderlyEventMessage<T>) message).getHash())) {
            return executor.select(((OrderlyEventMessage<T>) message).getHash());
        } else {
            return executor;
        }
    }

    private boolean isEmpty(final String t) {
        return t == null || t.isEmpty();
    }

}
