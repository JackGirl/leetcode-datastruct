package com.zbxx.leetcode.practice.list;


import com.zbxx.leetcode.struct.ListNode;

/**
 * 合并K个升序链表
 */
public class mergeKLists {


    /**
     * 也可以直接建堆
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode n = new ListNode(-1);
        ListNode t = n;
        boolean empty = true;
        int min = Integer.MAX_VALUE;
        int minId = -1;
        while (true) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    empty = false;
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        minId = i;
                    }
                }
            }
            if (!empty) {
                lists[minId] = lists[minId].next;
            }
            if (empty) {
                break;
            }
            n.next = new ListNode(min);
            n = n.next;
            empty = true;
            min = Integer.MAX_VALUE;
        }
        return t.next;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);

        ListNode t = new ListNode(1);
        t.next = new ListNode(3);
        t.next.next = new ListNode(4);
        ListNode s = new ListNode(2);
        s.next = new ListNode(6);
        ListNode ans = mergeKLists(new ListNode[]{first, t, s});
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

}
