package com.zbxx.leetcode.book.bst;


import com.zbxx.leetcode.struct.TreeNode;

/**
 * leetcode book bst deleteNode
 */
public class bst_deleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        int cmp = key - root.val;
        if (cmp < 0) {
            root.left = deleteNode(root.left, key);
        } else if (cmp > 0) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode min = findMin(root.right);
            swap(root, min);
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        TreeNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public void swap(TreeNode left, TreeNode right) {
        int val = left.val;
        left.val = right.val;
        right.val = val;
    }

}
