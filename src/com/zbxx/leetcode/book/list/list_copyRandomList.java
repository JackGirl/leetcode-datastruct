package com.zbxx.leetcode.book.list;


import java.util.HashMap;
import java.util.Map;

/**
 * leetcode book list  复制带随机指针的链表
 */
public class list_copyRandomList {


    class Node {
        int  val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node t = head;
        Node pre = null;
        while (t != null) {
            Node newNode = new Node(t.val);
            if (pre == null) {
                pre = newNode;
            } else {
                pre.next = newNode;
                pre = newNode;
            }
            map.put(t, newNode);
            t = t.next;
        }
        t = head;
        Node nn = map.get(head);
        while (t != null) {
            nn.random = map.get(t.random);
            t = t.next;
            nn = nn.next;
        }
        return map.get(head);
    }


}
