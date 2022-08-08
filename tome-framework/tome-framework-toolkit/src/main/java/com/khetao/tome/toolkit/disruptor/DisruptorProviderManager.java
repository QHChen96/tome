package com.khetao.tome.toolkit.disruptor;

import com.khetao.tome.toolkit.disruptor.consumer.QueueConsumer;
import com.khetao.tome.toolkit.disruptor.consumer.QueueConsumerFactory;
import com.khetao.tome.toolkit.disruptor.event.EventMessage;
import com.khetao.tome.toolkit.disruptor.event.EventMessageFactory;
import com.khetao.tome.toolkit.disruptor.event.OrderlyEventMessageFactory;
import com.khetao.tome.toolkit.disruptor.provider.DisruptorProvider;
import com.khetao.tome.toolkit.disruptor.thread.DisruptorThreadFactory;
import com.khetao.tome.toolkit.disruptor.thread.OrderlyExecutor;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenqinhao 2022/8/4
 * @email qhchen96@gmail.com
 */
public class DisruptorProviderManager<T> {

    public static final Integer DEFAULT_SIZE = 4096 << 1 << 1;

    private static final Integer DEFAULT_CONSUMER_SIZE = Runtime.getRuntime().availableProcessors() << 1;

    private final Integer size;

    private final Integer consumerSize;

    private final QueueConsumerFactory<T> consumerFactory;

    private DisruptorProvider<T> provider;

    public DisruptorProviderManager(final QueueConsumerFactory<T> consumerFactory, final Integer ringBufferSize) {
        this(consumerFactory,
                DEFAULT_CONSUMER_SIZE,
                ringBufferSize);
    }

    public DisruptorProviderManager(final QueueConsumerFactory<T> consumerFactory) {
        this(consumerFactory, DEFAULT_CONSUMER_SIZE, DEFAULT_SIZE);
    }

    public DisruptorProviderManager(final QueueConsumerFactory<T> consumerFactory,
                                   final int consumerSize,
                                   final int ringBufferSize) {
        this.consumerFactory = consumerFactory;
        this.size = ringBufferSize;
        this.consumerSize = consumerSize;
    }

    public void startup() {
        this.startup(false);
    }

    public void startup(final boolean isOrderly) {
        OrderlyExecutor executor = new OrderlyExecutor(isOrderly, consumerSize, consumerSize, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
                DisruptorThreadFactory.create("tome_disruptor_consumer_", false), new ThreadPoolExecutor.AbortPolicy());
        int newConsumerSize = this.consumerSize;
        EventFactory<EventMessage<T>> eventFactory;
        if (isOrderly) {
            newConsumerSize = 1;
            eventFactory = new OrderlyEventMessageFactory<>();
        } else {
            eventFactory = new EventMessageFactory<>();
        }
        Disruptor<EventMessage<T>> disruptor = new Disruptor<>(eventFactory,
                size,
                DisruptorThreadFactory.create("tome_disruptor_provider_" + consumerFactory.getName(), false),
                ProducerType.MULTI,
                new BlockingWaitStrategy());
        QueueConsumer<T>[] consumers = new QueueConsumer[newConsumerSize];
        disruptor.setDefaultExceptionHandler(new IgnoreExceptionHandler());
        disruptor.start();
        RingBuffer<EventMessage<T>> ringBuffer = disruptor.getRingBuffer();
        provider = new DisruptorProvider<>(ringBuffer, disruptor, isOrderly);
    }

    public DisruptorProvider<T> getProvider() {
        return provider;
    }

}
