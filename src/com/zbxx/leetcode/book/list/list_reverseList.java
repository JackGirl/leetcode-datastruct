package com.zbxx.leetcode.book.list;


import com.zbxx.leetcode.struct.ListNode;

/**
 * leetcode book list 反转链表
 */
public class list_reverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = head;
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            ListNode t = node;
            node = node.next;
            t.next = newHead;
            newHead = t;
        }

        return newHead;
    }

}
