package com.zbxx.leetcode.book.binaryTree;


import com.zbxx.leetcode.struct.TreeNode;

/**
 * leetcode  book 二叉树  路径和存在target
 */
public class binaryTree_hasPathNum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int sub = targetSum - root.val;
        if (sub == 0) {
            if (root.left == null && root.right == null) {
                return true;
            }
        }
        return hasPathSum(root.left, sub) || hasPathSum(root.right, sub);

    }


}
