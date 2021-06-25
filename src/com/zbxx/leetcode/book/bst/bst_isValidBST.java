package com.zbxx.leetcode.book.bst;


import com.zbxx.leetcode.struct.TreeNode;
import lombok.val;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

/**
 * leetcode book bst 验证二叉搜索树
 */
public class bst_isValidBST {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long pre = Long.MIN_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }


}
