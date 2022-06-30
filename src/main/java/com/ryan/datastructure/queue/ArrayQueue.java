package com.ryan.datastructure.queue;

import java.util.ArrayList;

/**
 * @author ryanzou
 */
public class ArrayQueue<E> implements Queue<E> {

    private ArrayList<E> array;

    public ArrayQueue() {
        array = new ArrayList<>();
    }

    public ArrayQueue(int capacity) {
        array = new ArrayList<>(capacity);
    }

    /**
     * 获取队列长度
     *
     * @return int
     */
    @Override
    public int getSize() {
        return array.size();
    }

    /**
     * 判空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 入队
     */
    @Override
    public void enqueue(E e) {
        array.add(getSize(), e);
    }

    /**
     * 出队
     *
     * @return E
     */
    @Override
    public E dequeue() {
        return array.remove(0);
    }

    /**
     * 获取首队
     *
     * @return E
     */
    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append("Queue: front [");
        for (int i = 0; i < getSize(); i++) {
            res.append(array.get(i));
            if (i != getSize()) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i%3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
