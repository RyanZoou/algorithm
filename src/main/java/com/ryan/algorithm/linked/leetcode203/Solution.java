package com.ryan.algorithm.linked.leetcode203;

import com.ryan.algorithm.linked.ListNode;

/**
 * @author ryanzou
 */
public class Solution {

    /**
     * 循环删除指定元素
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 递归删除指定元素
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsByRecursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElementsByRecursion(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode nodes = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7, null))));
        System.out.println(nodes);
        ListNode ret = (new Solution()).removeElementsByRecursion(nodes, 7);
        System.out.println(ret);
    }
}
