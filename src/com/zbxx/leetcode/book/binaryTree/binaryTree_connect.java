package com.zbxx.leetcode.book.binaryTree;


import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode book binaryTree  填充每个节点的下一个右侧节点指针
 */
public class binaryTree_connect {
    static class Node {
        public int  val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * bfs    因为是完全二叉树  还可以直接递归  另一种做法是 每次链接只链接当前节点的下一层 即当前节点看作已进行链接的节点
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        deque.offer(null);
        while (!deque.isEmpty()) {
            Node n = deque.poll();
            if (n == null) {
                if (!deque.isEmpty()) {
                    deque.offer(null);
                }
            } else {
                n.next = deque.peek();
                if (n.left != null) {
                    deque.offer(n.left);
                }
                if (n.right != null) {
                    deque.offer(n.right);
                }
            }
        }
        return root;
    }

}
