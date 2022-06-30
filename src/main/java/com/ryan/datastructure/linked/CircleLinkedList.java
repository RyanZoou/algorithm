package com.ryan.datastructure.linked;

/**
 * @author ryanzou
 */
public class CircleLinkedList<E> {

    private class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node head = null;
    private Node tail = null;

    public CircleLinkedList(int nums) {

        if (nums < 1) {
            throw new RuntimeException("nums < 1!");
        }

        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                head = node;
                head.next = head;
                tail = node;
            } else {
                tail.next = node;
                node.next = head;
                tail = node;
            }
        }

    }


    private CircleLinkedList() {
        this(5);
    }

    /**
     * 约瑟夫问题求解
     *
     * @param startNo  从第几个开始，环形链表的head
     * @param countNum 数几次
     * @param nums     原始环形链表的数量
     */
    public void exitCircle(int startNo, int countNum, int nums) {
        if (head == null || startNo < 1 || countNum < 1 || nums < 1 || startNo > nums) {
            throw new RuntimeException("params error!");
        }

        // 找准头指针、尾指针的位置
        for (int i = 0; i < startNo - 1; i++) {
            head = head.next;
            tail = tail.next;
        }

        while (true) {
            if (tail == head) {
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                head = head.next;
                tail = tail.next;
            }
            System.out.println(head.e + "元素出圈");

            // 修正头尾指针位置
            head = head.next;
            tail.next = head;
        }
        System.out.println("最后圈内留下的元素：" + head.e);
    }


    public static void main(String[] args) {
        CircleLinkedList<Object> objectCircleLinkedList = new CircleLinkedList<>(41);
        objectCircleLinkedList.exitCircle(1, 3, 41);
    }

}

























