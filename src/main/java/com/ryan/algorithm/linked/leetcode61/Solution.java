package com.ryan.algorithm.linked.leetcode61;

import com.ryan.algorithm.linked.ListNode;

/**
 * @author ryanzou
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        int rotate = size - k % size;

        if (rotate == size) {
            return head;
        }

        // 首位相连成循环链表
        cur.next = head;

        while (rotate-- > 0) {
            cur = cur.next;
        }
        ListNode retNode = cur.next;
        cur.next = null;
        return retNode;
    }
}
