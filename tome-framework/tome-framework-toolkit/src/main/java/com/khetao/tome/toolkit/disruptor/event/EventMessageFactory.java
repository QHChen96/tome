package com.khetao.tome.toolkit.disruptor.event;

import com.lmax.disruptor.EventFactory;

/**
 * @author chenqinhao 2022/8/4
 * @email qhchen96@gmail.com
 */
public class EventMessageFactory<T> implements EventFactory<EventMessage<T>> {

    @Override
    public EventMessage<T> newInstance() {
        return new EventMessage<>();
    }
}
