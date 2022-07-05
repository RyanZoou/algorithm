package com.ryan.datastructure.queue;

import com.ryan.datastructure.heap.MaxHeap;

/**
 * @author ryanzou
 */
public class PriorityQueue <E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    public PriorityQueue(MaxHeap mh) {
        this.maxHeap = mh;
    }

    /**
     * 获取队列长度
     *
     * @return int
     */
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    /**
     * 判空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 出队
     *
     * @return E
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    /**
     * 获取首队
     *
     * @return E
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
