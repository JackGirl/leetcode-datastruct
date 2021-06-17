package com.zbxx.leetcode.book.list;


import com.zbxx.leetcode.struct.ListNode;

import java.util.List;

/**
 * leetcode book list 是否回文链表
 */
public class list_isPalindrome {


    /**
     * 不要求o1额外空间可以直接放入栈   或者反转链表比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        ListNode node = slow.next;
        while (node != null) {
            if (node.val == head.val) {
                head = head.next;
                node = node.next;
            } else {
                slow.next = reverse(slow.next);
                return false;
            }
        }
        slow.next = reverse(slow.next);
        return true;
    }

    public static ListNode reverse(ListNode head) {
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
