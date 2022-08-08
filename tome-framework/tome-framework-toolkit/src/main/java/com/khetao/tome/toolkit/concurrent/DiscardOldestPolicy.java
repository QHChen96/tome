package com.khetao.tome.toolkit.concurrent;

/**
 * @author chenqinhao 2022/8/5
 * @email qhchen96@gmail.com
 */
public class DiscardOldestPolicy<E> implements Rejector<E> {

    @Override
    public void reject(E e, MemorySafeLinkedBlockingQueue<E> queue) {
        queue.poll();
        queue.offer(e);
    }
}
