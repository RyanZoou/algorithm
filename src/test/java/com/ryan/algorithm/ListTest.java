package com.ryan.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * ArrayList 和 LinkedList
 *
 * ArrayList 底层是数组，查询快，插入慢，有移动操作
 * LinkedList 底层是链表，插入快，查询慢
 *
 * 本例子用于实验证明，当List达到一定的量级后，LinkedList插入反而比ArrayList慢
 *
 * @author ryanzou
 */
public class ListTest {

    public static void main(String[] args) {
        addLinkedList();
        addArrayList();
    }


    public static void addLinkedList() {
        long begin = System.currentTimeMillis();
        List<Integer> list = new LinkedList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
            list.add(3, 10);
        }
        System.out.println("linkedList time==" + (System.currentTimeMillis() - begin));
    }


    public static void addArrayList() {
        long begin = System.currentTimeMillis();
        List list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        System.out.println("arrayList time==" + (System.currentTimeMillis() - begin));
    }
}
