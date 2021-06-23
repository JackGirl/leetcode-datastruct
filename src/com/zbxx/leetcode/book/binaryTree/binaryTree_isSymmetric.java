package com.zbxx.leetcode.book.binaryTree;


import com.zbxx.leetcode.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode book  二叉树 对称二叉树
 */
public class binaryTree_isSymmetric {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    /**
     * 另外一种做法就是前序后续分别遍历 然后 倒叙后续遍历 依次判断和前序是不是一样
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.poll();
            TreeNode right = deque.poll();
            if ((left == null && right != null) || (right == null && left != null)) {
                return false;
            }
            if (left != null && right != null) {
                if (left.val == right.val) {
                    deque.offer(left.left);
                    deque.offer(right.right);
                    deque.offer(left.right);
                    deque.offer(right.left);
                } else {
                    return false;
                }
            }
        }
        return true;
    }


}
