package com.zbxx.leetcode.book.queueAndstack;

import cn.hutool.core.collection.CollectionUtil;

import java.util.*;

/**
 * leetcode book queueAndStack 克隆图
 */
public class queueAndStack_dfs_cloneGraph {

    public static class Node {
        public int        val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors = CollectionUtil.newArrayList(n2, n4);
        n2.neighbors = CollectionUtil.newArrayList(n1, n3);
        n3.neighbors = CollectionUtil.newArrayList(n2, n4);
        n4.neighbors = CollectionUtil.newArrayList(n1, n3);


        System.out.println(cloneGraph(n1).val);
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> created = new HashMap<>();
        dfs(node, visited, created);
        return created.get(node);
    }

    private static void dfs(Node node, Set<Node> visited, Map<Node, Node> created) {
        if (visited.contains(node)) {
            return;
        }
        Node n = created.getOrDefault(node, new Node(node.val));
        visited.add(node);
        created.put(node, n);
        List<Node> nears = node.neighbors;
        List<Node> news = new ArrayList<>();
        for (Node N : nears) {
            dfs(N, visited, created);
            news.add(created.get(N));
        }
        n.neighbors = news;
    }

}
