package com.zbxx.leetcode.book.bst;

import com.zbxx.leetcode.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class bst_BSTIterator {

    Deque<Integer> s = new LinkedList<>();

    public bst_BSTIterator(TreeNode root) {
        load(root);
    }

    private void load(TreeNode root) {
        if (root == null) {
            return;
        }
        load(root.left);
        s.offer(root.val);
        load(root.right);
    }

    public int next() {
        return s.poll();
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }


}
