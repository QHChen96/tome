package com.khetao.tome.toolkit.concurrent;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public interface Rejector<E> {

    void reject(E e, MemorySafeLinkedBlockingQueue<E> queue);

}
