package com.zbxx.leetcode.practice.list;


import com.zbxx.leetcode.struct.ListNode;

/**
 * leetcode 160 相交链表  找相交点
 * 还有一种方法是用set 查看是否走过当前节点
 */
public class getIntersectionNode {


    public static void main(String[] args) {
        ListNode A = new ListNode(4);
        ListNode t1 = new ListNode(1);
        ListNode t8 = new ListNode(8);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(5);
        A.next = t1;
        t1.next = t8;
        t8.next = t4;
        t4.next = t5;


        ListNode B = new ListNode(5);
        ListNode b6 = new ListNode(6);
        ListNode b1 = new ListNode(1);
        B.next = b6;
        b6.next = b1;
        b1.next = t8;
        System.out.println(new getIntersectionNode().getIntersectionNode(A, B).val);

    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode head = headA;
        while (head.next != null) {
            head = head.next;
        }
        ListNode temp = head;
        head.next = headB;
        ListNode A = headA;
        ListNode B = headA;
        boolean start = false;
        boolean find = false;
        while (B != null) {
            if (A.equals(B) && start) {
                find = true;
                break;
            }
            start = true;
            A = A.next;
            B = B.next;
            if (B != null) {
                B = B.next;
            }

        }
        A = headA;
        while (find && A != B) {
            A = A.next;
            B = B.next;
        }
        temp.next = null;
        return find ? A : null;
    }


}
