package com.ryan.datastructure.heap;

import java.util.ArrayList;

/**
 * @author ryanzou
 */
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap(ArrayList<E> arrayList) {
        int index = parent(arrayList.size() - 1);
        for (int i = index; i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index <= 0) {
            throw new RuntimeException("index 值不合法！");
        }
        return (index - 1) / 2;
    }

    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            swap(data, parent(index), index);
            index = parent(index);
        }
    }

    /**
     * 删除堆中元素，通过将删除元素与数组尾部交换，然后将尾部删除，再下推被删除的元素
     *
     * @param e
     */
    private void remove(E e) {
        int index = data.indexOf(e);
        if (index == -1) {
            return;
        }
        swap(data, index, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(index);
    }

    public E findMax() {
        if (data.size() == 0) {
            throw new RuntimeException("this is a empty heap");
        }
        return data.get(0);
    }

    public E extractMax() {
        if (data.isEmpty()) {
            throw new RuntimeException("this is a empty heap");
        }
        swap(data, 0, data.size() - 1);
        E max = data.remove(data.size() - 1);
        siftDown(0);
        return max;
    }

    private void siftDown(int index) {
        int size = size();
        if (index >= size) {
            throw new RuntimeException("index 值不合法！");
        }
        Integer maxChildIndex = extraMaxChildIndex(index);
        if (maxChildIndex != null) {
            swap(data, maxChildIndex, index);
            siftDown(maxChildIndex);
        }
    }

    private Integer extraMaxChildIndex(int index) {
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        if (leftIndex > -1 && rightIndex > -1) {
            E leftChild = data.get(leftIndex);
            E rightChild = data.get(rightIndex);

            E maxChild;
            int maxIndex;
            if (leftChild.compareTo(rightChild) > 0) {
                maxChild = leftChild;
                maxIndex = leftIndex;
            } else {
                maxChild = rightChild;
                maxIndex = rightIndex;
            }
            if (maxChild.compareTo(data.get(index)) > 0) {
                return maxIndex;
            }
        } else {
            if (leftIndex > -1 && data.get(leftIndex).compareTo(data.get(index)) > 0) {
                return leftIndex;
            }
            if (rightIndex > -1 && data.get(rightIndex).compareTo(data.get(index)) > 0) {
                return rightIndex;
            }
        }
        return null;
    }


    private void swap(ArrayList<E> data, int index1, int index2) {
        E val1 = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, val1);
    }

    private int leftChild(int index) {
        int i = 2 * index + 1;
        return i < size() ? i : -1;
    }

    private int rightChild(int index) {
        int i = 2 * index + 2;
        return i < size() ? i : -1;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.add(8);
        maxHeap.add(12);
        maxHeap.add(14);
        maxHeap.add(19);
        maxHeap.add(2);
        maxHeap.add(6);
        maxHeap.add(9);
        maxHeap.add(5);
        maxHeap.add(7);
        maxHeap.remove(12);
        System.out.println(maxHeap);
    }

}
