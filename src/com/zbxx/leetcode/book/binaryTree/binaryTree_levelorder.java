package com.zbxx.leetcode.book.binaryTree;

import com.zbxx.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/**
 * leetcode book 二叉树  层序
 */
public class binaryTree_levelorder {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        deque.offer(null);
        List<Integer> levelData = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node == null) {
                result.add(levelData);
                levelData = new ArrayList<>();
                if (deque.peek() != null) {
                    deque.offer(null);
                }
            } else {
                levelData.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return result;
    }


}
