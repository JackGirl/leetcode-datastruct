package com.zbxx.leetcode.book.binaryTree;

import com.zbxx.leetcode.struct.TreeNode;

/**
 * leetcode book binaryTree 前序中序构造二叉树
 */
public class binary_buildTree2 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 这里方法和后续一样 前序第一个为root
     */
    public TreeNode build(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (iStart > iEnd || pStart > pEnd || pStart < 0 || pEnd == preorder.length || iStart < 0 || iEnd == inorder.length) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pStart]);
        int keyIndex = Integer.MIN_VALUE;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == node.val) {
                keyIndex = i;
                break;
            }
        }

        node.left = build(preorder, inorder, pStart + 1, pStart + keyIndex - iStart, iStart, keyIndex - 1);
        node.right = build(preorder, inorder, pStart + keyIndex - iStart + 1, pEnd, keyIndex + 1, iEnd);
        return node;
    }


}
