package com.ryan.datastructure.linked;

/**
 * @author ryanzou
 */
public class SingleLinkedList<E> {

    private class Node {
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

    /**
     * 虚拟头节点
     */
    private Node dummyHead;

    private int size;

    public SingleLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new RuntimeException("add failed, illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("get failed, illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    public Boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new RuntimeException("set failed, illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("remove failed, illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node deleteNode = prev.next;

        // 指针变动
        prev.next = deleteNode.next;
        // 滞空删除节点
        deleteNode.next = null;
        size--;

        return deleteNode.e;
    }


    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定元素
     *
     * @param e
     */
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            Node deleteNode = prev.next;
            if (deleteNode.e.equals(e)) {

                // 指针变动
                prev.next = deleteNode.next;
                // 滞空删除节点，辅助gc
                deleteNode.next = null;
                size--;
            } else {
                prev = prev.next;
            }
        }
    }

    /**
     * 翻转链表
     */
    public void reverseSet() {
        Node cur = dummyHead.next;
        Node reverseHead = new Node();

        while (cur != null) {
            Node next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        dummyHead = reverseHead;
    }

    @Override
    public String toString() {
        StringBuffer builder = new StringBuffer();
        Node cur = dummyHead.next;
        while (cur != null) {
            builder.append(cur).append("->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }


    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.addFirst(5);
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(1, 100);
        linkedList.removeElement(5);
        System.out.println(linkedList);
        linkedList.reverseSet();
        System.out.println(linkedList);
    }
}























