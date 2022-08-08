package com.khetao.tome.toolkit.disruptor.provider;

import com.khetao.tome.toolkit.disruptor.event.EventMessage;
import com.khetao.tome.toolkit.disruptor.event.OrderlyEventMessage;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.EventTranslatorTwoArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenqinhao 2022/8/4
 * @email qhchen96@gmail.com
 */
@Slf4j
public class DisruptorProvider<T> {

    private final RingBuffer<EventMessage<T>> ringBuffer;

    private final Disruptor<EventMessage<T>> disruptor;

    private final boolean isOrderly;

    private final EventTranslatorOneArg<EventMessage<T>, T> translatorOneArg = (event, sequence, t) -> event.setData(t);

    private final EventTranslatorTwoArg<EventMessage<T>, T, String> orderlyArg = (event, sequence, t, orderly) -> {
        if (event instanceof OrderlyEventMessage) {
            ((OrderlyEventMessage<T>) event).setHash(orderly);
        }
        event.setData(t);
    };

    public DisruptorProvider(RingBuffer<EventMessage<T>> ringBuffer, Disruptor<EventMessage<T>> disruptor, boolean isOrderly) {
        this.ringBuffer = ringBuffer;
        this.disruptor = disruptor;
        this.isOrderly = isOrderly;
    }

    public void onData(final T data) {
        if (isOrderly) {
            throw new IllegalArgumentException("The current provider is of orderly type. Please use onOrderlyData() method.");
        }
        try {
            ringBuffer.publishEvent(translatorOneArg, data);
        } catch (Exception ex) {
            log.error("ex", ex);
        }
    }

    public void onOrderlyData(final T data, final String... hashArray) {
        if (!this.isOrderly) {
            throw new IllegalArgumentException("The current provider is not of orderly type. Please use onData() method.");
        }
        try {
            String hash = String.join(":", hashArray);
            ringBuffer.publishEvent(orderlyArg, data, hash);
        } catch (Exception ex) {
            log.error("ex", ex);
        }
    }

    public void shutdown() {
        if (null != disruptor) {
            disruptor.shutdown();
        }
    }
}
