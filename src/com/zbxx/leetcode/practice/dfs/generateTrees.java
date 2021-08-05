package com.zbxx.leetcode.practice.dfs;


import cn.hutool.core.util.StrUtil;
import com.zbxx.leetcode.struct.TreeNode;

import java.util.*;

/**
 * 95 不同的二叉搜索树 2
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 这题也算dp吗 不算法
 */
public class generateTrees {


    public List<TreeNode> generateTrees(int n) {
        Map<String, List<TreeNode>> dp = new HashMap<>();
        List<TreeNode> ans = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            ans.addAll(dfs(dp, i, 1, n));
        }
        return ans;
    }

    private List<TreeNode> dfs(Map<String, List<TreeNode>> dp, int N, int l, int r) {
        if (l > N || l > r || N > r) {
            return null;
        }
        String key = N + "." + l + "." + r;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        List<TreeNode> leftNodes = new LinkedList<>();
        for (int i = l; i < N; i++) {
            List<TreeNode> left = dfs(dp, i, l, N - 1);
            if (left != null) {
                leftNodes.addAll(left);
            }
        }
        List<TreeNode> rightNode = new LinkedList<>();
        for (int i = N + 1; i <= r; i++) {
            List<TreeNode> right = dfs(dp, i, N + 1, r);
            if (right != null) {
                rightNode.addAll(right);
            }
        }
        List<TreeNode> ans = new LinkedList<>();
        if (!leftNodes.isEmpty() && !rightNode.isEmpty()) {
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode treeNode : rightNode) {
                    TreeNode root = new TreeNode(N);
                    root.left = leftNode;
                    root.right = treeNode;
                    ans.add(root);
                }
            }
        } else {
            if (!rightNode.isEmpty()) {
                for (TreeNode treeNode : rightNode) {
                    TreeNode root = new TreeNode(N);
                    root.right = treeNode;
                    ans.add(root);
                }
            } else if (!leftNodes.isEmpty()) {
                for (TreeNode leftNode : leftNodes) {
                    TreeNode root = new TreeNode(N);
                    root.left = leftNode;
                    ans.add(root);
                }
            } else {
                ans.add(new TreeNode(N));
            }
        }
        dp.put(key, ans);
        System.out.println(StrUtil.toString(ans));
        return ans;
    }


    public static void toString(TreeNode node) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(node);
        while (!deque.isEmpty()) {
            TreeNode n = deque.removeFirst();
            System.out.print(n.val + ",");
            if (n.left != null) {
                deque.addLast(n.left);
            }
            if (n.right != null) {
                deque.addLast(n.right);
            }
        }
        return;
    }


    public static void main(String[] args) {
        List<TreeNode> ans = new generateTrees().generateTrees(3);
        for (int i = 0; i < ans.size(); i++) {
            toString(ans.get(i));
            System.out.println();
        }
    }


}
