package com.zbxx.leetcode.book.ntree;

import cn.hutool.core.util.ObjectUtil;

import java.util.*;


/**
 * leetcode book ntree  迭代前序遍历ntree
 */
public class ntree_preorder {
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

    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                result.add(root.val);
                visited.add(root);
                if (root.children != null && root.children.size() > 0) {
                    root = root.children.get(0);
                } else {
                    root = null;
                }
            }
            root = stack.pop();
            Node t = root;
            if (root.children != null && root.children.size() > 0) {
                for (Node n : root.children) {
                    if (!visited.contains(n)) {
                        root = n;
                        break;
                    }
                }
                if (root == t) {
                    root = null;
                } else {
                    stack.push(t);
                }
            } else {
                root = null;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);

        n.children = Arrays.asList(n1, n2, n3);
        n1.children = Arrays.asList(n4, n5);
        System.out.println(ObjectUtil.toString(preorder(n)));
    }


}
