package com.zbxx.leetcode.book.list;


import com.zbxx.leetcode.struct.ListNode;

/**
 * leetcode  book  list 扁平化多级双向链表
 */
public class list_flatten {

    static class Node {
        public int  val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node _2 = new Node(2);
        head.next = _2;
        Node _3 = new Node(3);
        _2.next = _3;
        Node _4 = new Node(4);
        _3.next = _4;
        Node _5 = new Node(5);
        _4.next = _5;

        Node child = new Node(6);
        child.next = new Node(7);
        _2.child = child;
        Node t = flatten(head);
        System.out.println(t);
    }


    public static Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node nh = new Node();
        concat(head, nh);
        Node t = nh.next;
        t.prev = null;
        return t;
    }

    public static Node concat(Node node, Node prev) {
        while (node != null) {
            prev.next = node;
            node.prev = prev;
            prev = node;
            Node t = node.next;
            node.next = null;
            if (t != null) {
                t.prev = null;
            }
            if (node.child != null) {
                prev = concat(node.child, prev);
            }
            node.child = null;
            node = t;
        }
        return prev;
    }


}
