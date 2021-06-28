package com.zbxx.leetcode.book.ntree;

import java.util.*;

public class ntree_postorder {
    private static class Node {
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

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            if (n.children != null) {
                for (Node t : n.children) {
                    stack.push(t);
                }
            }
            result.add(n.val);
        }
        Collections.reverse(result);
        return result;
    }


}
