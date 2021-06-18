package com.zbxx.leetcode.practice.list;


import com.zbxx.leetcode.struct.ListNode;
import com.zbxx.leetcode.struct.TreeNode;

/**
 * 109.list 有序链表转换二叉搜索树
 */
public class sortedListToBST {


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        if (prev != null) {
            prev.next = null;
        }
        root.left = sortedListToBST(head);
        return root;
    }


}
