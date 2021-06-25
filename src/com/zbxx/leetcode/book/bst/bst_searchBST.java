package com.zbxx.leetcode.book.bst;


import com.zbxx.leetcode.struct.TreeNode;

/**
 * leetcode bst search
 */
public class bst_searchBST {


    /**
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        int cmp = val - root.val;
        if (cmp > 0) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

}
