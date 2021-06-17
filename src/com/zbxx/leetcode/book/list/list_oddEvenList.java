package com.zbxx.leetcode.book.list;


import com.zbxx.leetcode.struct.ListNode;

/**
 * leetcode book list  奇偶链表
 */
public class list_oddEvenList {

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
        System.out.println(oddEvenList(head).val);
    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = 1;
        ListNode node = head.next;
        //上一个插入的节点
        ListNode prevInsert = head;
        //元素链接的上个节点
        ListNode pr = null;
        while (node != null) {
            size++;
            ListNode t = node;
            node = node.next;
            if (size % 2 == 1) {
                ListNode pn = prevInsert.next;
                t.next = pn;
                prevInsert.next = t;
                prevInsert = t;
                pr.next = node;
            } else {
                pr = t;
            }
        }
        return head;
    }


}
