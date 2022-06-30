package com.ryan.algorithm.linked;

/**
 * @author ryanzou
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuffer builder = new StringBuffer();
        ListNode cur = this;
        while (null != cur) {
            builder.append(cur.val).append("->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }

}
