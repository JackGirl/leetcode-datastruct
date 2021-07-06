package com.zbxx.leetcode.practice.tree;

import com.zbxx.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树锯齿形遍历
 */
public class zigzagLevelOrder {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        deque.offer(null);
        boolean left = true;
        LinkedList<Integer> list = new LinkedList<>();
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.poll();
            if (treeNode == null) {
                result.add(list);
                list = new LinkedList<>();
                if (!deque.isEmpty()) {
                    deque.offer(null);
                }
                left = !left;
            } else {
                if (left) {
                    list.addLast(treeNode.val);
                } else {
                    list.addFirst(treeNode.val);
                }
                if (treeNode.left != null) {
                    deque.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offer(treeNode.right);
                }
            }
        }
        return result;
    }

}
