package com.zbxx.leetcode.book.ntree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ntree_floororder {

    static class Node {
        public int        val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        deque.addLast(null);
        List<Integer> floor = new ArrayList<>();
        while (!deque.isEmpty()) {
            Node t = deque.poll();
            if (t == null) {
                result.add(floor);
                if (!deque.isEmpty()) {
                    deque.addLast(null);
                }
                floor = new ArrayList<>();
            } else {
                floor.add(t.val);
                if (t.children != null) {
                    for (Node c : t.children) {
                        deque.addLast(c);
                    }
                }
            }
        }
        return result;
    }

}
