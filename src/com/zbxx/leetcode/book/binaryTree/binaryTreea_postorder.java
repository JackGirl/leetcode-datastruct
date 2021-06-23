package com.zbxx.leetcode.book.binaryTree;

import com.zbxx.leetcode.struct.TreeNode;

import java.util.*;


/**
 * leetcode book 二叉树 非递归后续二叉树
 */
public class binaryTreea_postorder {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            result.add(node.val);
        }
        Collections.reverse(result);
        return result;
    }


}
