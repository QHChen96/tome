package com.khetao.tome.toolkit.concurrent;

/**
 * 丢弃策略
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public class DiscardPolicy<E> implements Rejector<E> {

    @Override
    public void reject(E e, MemorySafeLinkedBlockingQueue<E> queue) {

    }

}
