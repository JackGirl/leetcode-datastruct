package com.zbxx.leetcode.book.list;

import com.zbxx.leetcode.struct.ListNode;

/**
 * leetcode book list 判断链表环
 */
public class list_hasCycle {


    public boolean hasCyCle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return false;
    }


}
