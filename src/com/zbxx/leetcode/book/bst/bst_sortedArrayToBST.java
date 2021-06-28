package com.zbxx.leetcode.book.bst;

import com.zbxx.leetcode.struct.TreeNode;

/**
 * leetcode book bst 有序数组转为二叉搜索树
 */
public class bst_sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }


    public TreeNode build(int[] treeValues, int begin, int end) {
        if (begin < 0 || end > treeValues.length || begin > end) {
            return null;
        }
        int rootIndex = begin + (end - begin) / 2;
        TreeNode node = new TreeNode(treeValues[rootIndex]);
        node.left = build(treeValues, begin, rootIndex - 1);
        node.right = build(treeValues, rootIndex + 1, end);
        return node;
    }

}
