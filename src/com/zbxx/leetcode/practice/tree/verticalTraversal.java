package com.zbxx.leetcode.practice.tree;


import com.zbxx.leetcode.struct.TreeNode;

import java.util.*;

/**
 * 二叉树的垂序便利
 */
public class verticalTraversal {

    public class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        TreeMap<Integer, PriorityQueue<Node>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        Collection<PriorityQueue<Node>> set = map.values();
        for (PriorityQueue<Node> integers : set) {
            LinkedList<Integer> list = new LinkedList<>();
            while (!integers.isEmpty()) {
                list.add(integers.poll().val);
            }
            ans.add(list);
        }
        return ans;
    }

    private void dfs(TreeNode root, int col, int row, TreeMap<Integer, PriorityQueue<Node>> map) {
        if (root == null) {
            return;
        }
        PriorityQueue<Node> queue = map.getOrDefault(col, new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.row == o2.row) {
                    if (o1.col == o2.col) {
                        return o1.val - o2.val;
                    }
                    return o1.col - o2.col;
                }
                return o1.row - o2.row;
            }
        }));
        Node n = new Node(row, col, root.val);
        queue.offer(n);
        map.put(col, queue);
        dfs(root.left, col - 1, row + 1, map);
        dfs(root.right, col + 1, row + 1, map);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
    }

}
