package com.zbxx.leetcode.book.list;


import com.zbxx.leetcode.struct.ListNode;

/**
 * leetcode book list 旋转链表
 */
public class list_rotateRight {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode _2 = new ListNode(2);
        head.next = _2;
        ListNode _3 = new ListNode(3);
        _2.next = _3;
        ListNode _4 = new ListNode(4);
        _3.next = _4;
        ListNode _5 = new ListNode(5);
        _4.next = _5;
        System.out.println(rotateRight(head, 96).val);
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode t = head;
        int size = 0;
        while (t != null) {
            size++;
            t = t.next;
        }
        int rotateSize = k % size;
        ListNode fast = head;
        if (rotateSize == 0) {
            return head;
        }
        while (rotateSize-- > 0) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode nh = slow.next;
        slow.next = null;
        ListNode sn = nh;
        while (sn.next != null) {
            sn = sn.next;
        }
        sn.next = head;
        return nh;
    }

}
