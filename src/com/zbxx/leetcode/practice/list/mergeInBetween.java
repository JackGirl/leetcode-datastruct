package com.zbxx.leetcode.practice.list;


import com.zbxx.leetcode.struct.ListNode;

/**
 * 1669.list 合并两个链表
 */
public class mergeInBetween {


    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node = list1;
        int index = 0;
        ListNode prev = null;
        while (index < a) {
            prev = node;
            node = node.next;
            index++;
        }

        while (index < b) {
            node = node.next;
            index++;
        }
        ListNode nh;
        if (prev != null) {
            nh = list1;
            prev.next = list2;
        } else {
            nh = list2;
        }
        ListNode s2 = list2;
        while (s2.next != null) {
            s2 = s2.next;
        }
        s2.next = node.next;
        return nh;

    }

}
