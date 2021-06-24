package com.zbxx.leetcode.book.binaryTree;


import com.zbxx.leetcode.struct.TreeNode;

import java.util.Arrays;

/**
 * leetcode book binaryTree  后续和前序构造二叉树
 */
public class binary_BuildTree {


    public static void main(String[] args) {
        int[] inor = {2, 1};
        int[] postOr = {2, 1};
        TreeNode root = buildTree(inor, postOr);
        System.out.println(root);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static TreeNode build(int[] inorder, int[] postOrder, int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart < 0 || iEnd > inorder.length - 1 || iStart > iEnd || pStart > pEnd || pStart < 0 || pEnd > postOrder.length - 1) {
            return null;
        }
        TreeNode node = new TreeNode(postOrder[pEnd]);
        int keyIndex = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == node.val) {
                keyIndex = i;
                break;
            }
        }
        node.left = build(inorder, postOrder, iStart, keyIndex - 1, pStart, pStart + keyIndex - iStart - 1);
        node.right = build(inorder, postOrder, keyIndex + 1, iEnd, pStart + keyIndex - iStart, pEnd - 1);
        return node;
    }


}
