package com.zbxx.leetcode.book.list;


import com.zbxx.leetcode.struct.ListNode;

/**
 * 删除单链表倒数第N个节点  直接求解 先算长度再遍历一次
 */
public class list_removeNthFromEnd {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode pre = slow;
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (slow == head) {
            return slow.next;
        } else {
            pre.next = slow.next;
            return head;
        }

    }


}
