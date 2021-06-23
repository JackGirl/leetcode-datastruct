package com.zbxx.leetcode.book.binaryTree;


import com.zbxx.leetcode.struct.TreeNode;

/**
 * leetcode book 二叉树  最大深度
 */
public class binaryTree_maxDepth {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
