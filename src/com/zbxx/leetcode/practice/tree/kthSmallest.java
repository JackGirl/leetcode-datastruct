package com.zbxx.leetcode.practice.tree;

import com.zbxx.leetcode.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树 第K小的数
 */
public class kthSmallest {


    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            root = node.right;
        }
        return -1;
    }


}
