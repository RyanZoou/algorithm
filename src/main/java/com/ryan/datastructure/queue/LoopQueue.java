package com.ryan.datastructure.queue;

/**
 * @author ryanzou
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 获取队列的容量
     *
     * @return int
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 获取队列长度
     *
     * @return int
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if (isFull()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 出队
     *
     * @return E
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("cannot dequeue from empty queue");
        }
        E ret = data[front];
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 获取首队
     *
     * @return E
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data[front];
    }

    /**
     * 判断循环队列是否已经满了
     *
     * @return
     */
    private boolean isFull() {
        return (tail + 1) % data.length == front;
    }

    /**
     * 扩容队列
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Queue:size = %d, capacity = %d\n", size, getCapacity()));
        res.append("Queue: front [");
        for (int i = 0; i < getSize(); i++) {
            res.append(data[i]);
            if (i != getSize()) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
