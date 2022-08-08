package com.khetao.tome.toolkit.concurrent;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public class AbortPolicy<E> implements Rejector<E> {

    @Override
    public void reject(E e, MemorySafeLinkedBlockingQueue<E> queue) {
        throw new RejectException("no more memory can be used!");
    }
}
