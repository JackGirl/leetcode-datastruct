package com.zbxx.leetcode.book.ntree;


import java.util.Arrays;
import java.util.List;

/**
 * leetcode book ntree  最大深度
 */
public class ntree_maxDepth {

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

    int d = 0;

    public int maxDepth(Node root) {
        deep(root, d);
        return d;
    }

    public void deep(Node root, int depth) {
        if (root == null) {
            return;
        }
        d = Math.max(depth + 1, d);
        if (root.children != null) {
            for (Node c : root.children) {
                deep(c, depth + 1);
            }
        }
    }


}
