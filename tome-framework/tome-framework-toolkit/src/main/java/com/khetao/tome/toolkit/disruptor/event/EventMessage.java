package com.khetao.tome.toolkit.disruptor.event;

import lombok.Data;

/**
 * @author chenqinhao 2022/8/4
 * @email qhchen96@gmail.com
 */
@Data
public class EventMessage<T> {

    private T data;

}
