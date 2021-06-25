package com.zbxx.leetcode.book.bst;

import com.zbxx.leetcode.struct.TreeNode;

/**
 * leetcode book bst insert
 */
public class bst_insertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        int rs = val - root.val;
        if (rs > 0) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }


}
