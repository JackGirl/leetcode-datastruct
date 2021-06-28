package com.zbxx.leetcode.book.bst;

import com.zbxx.leetcode.struct.TreeNode;

/**
 * leetcode book bst 二叉搜索数 验证高度平衡
 */
public class bst_isBalanced {


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root);
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = height(node.left);
        int r = height(node.right);
        return Math.max(l, r) + 1;
    }

    public boolean isValid(TreeNode node) {
        if (node == null) {
            return true;
        }
        int l = height(node.left);
        int r = height(node.right);
        if (Math.abs(l - r) <= 1 && Math.abs(l - r) >= 0) {
            return isValid(node.left) && isValid(node.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        bst_isBalanced bst_isBalanced = new bst_isBalanced();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(bst_isBalanced.isValid(root));
        ;
    }

}
