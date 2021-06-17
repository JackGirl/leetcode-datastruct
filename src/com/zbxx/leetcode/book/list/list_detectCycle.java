package com.zbxx.leetcode.book.list;


import com.zbxx.leetcode.struct.ListNode;

/**
 * leetcode book 链表环入口
 * <p>
 * 实现方式有hash  快慢指针
 */
public class list_detectCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode _2 = new ListNode(2);
        head.next = _2;
        ListNode _3 = new ListNode(0);
        _2.next = _3;
        ListNode _4 = new ListNode(-4);
        _3.next = _4;
        _4.next = _2;
        System.out.println(detectCycle(head).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast != null && fast == slow) {
                slow = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }

        return null;
    }

}
