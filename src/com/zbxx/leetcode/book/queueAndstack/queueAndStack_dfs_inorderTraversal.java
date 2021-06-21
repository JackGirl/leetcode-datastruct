package com.zbxx.leetcode.book.queueAndstack;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.zbxx.leetcode.struct.TreeNode;

import java.util.*;

/**
 * leetcode book 队列和栈  二叉树中序遍历
 */
public class queueAndStack_dfs_inorderTraversal {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        System.out.println(StrUtil.toString(inorderTraversal(root)));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        if (root == null) {
            return data;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode top = stack.pop();
            data.add(top.val);
            node = top.right;
        }
        return data;
    }


}
