package com.ryan.datastructure.queue;

/**
 * @author ryanzou
 */
public interface Queue<E> {

    /**
     * 获取队列长度
     *
     * @return int
     */
    int getSize();

    /**
     * 判空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 入队
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return E
     */
    E dequeue();

    /**
     * 获取首队
     *
     * @return E
     */
    E getFront();

}
