package com.zbxx.leetcode.practice.table;


import java.util.*;

/**
 * book设计数据结构 460 LFUCache
 */
public class LFUCache {


    static class ListNode {

        Node first = new Node(-1, -1);

        Node last = new Node(-1, -1);

        public ListNode() {
            first.next = last;
            last.prev = first;
        }

        public void insertFirst(Node node) {
            Node next = first.next;
            node.next = next;
            next.prev = node;
            node.prev = first;
            first.next = node;
        }

        public boolean isEmpty() {
            return this.first.next == this.last;
        }

        public Node removeLast() {
            if (!isEmpty()) {
                Node l = this.last.prev;
                last.prev = l.prev;
                l.prev.next = last;
                l.prev = null;
                l.next = null;
                return l;
            }
            return null;
        }
    }

    static class Node {

        int key;

        int val;

        int count = 1;

        Node prev;

        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }


    }

    //count
    TreeMap<Integer, ListNode> count;
    //search
    Map<Integer, Node>         cache;

    int maxSize;


    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.maxSize = capacity;
        this.count = new TreeMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        node.count++;
        ListNode listNode = count.getOrDefault(node.count, new ListNode());
        listNode.insertFirst(node);
        count.put(node.count, listNode);
        return node.val;
    }

    public void put(int key, int value) {
        if (this.maxSize == 0) {
            return;
        }
        Node n = cache.get(key);
        if (n == null) {
            n = new Node(key, value);
            if (maxSize == cache.size()) {
                Map.Entry<Integer, ListNode> listNodeEntry = count.pollFirstEntry();
                while (!count.isEmpty() && listNodeEntry.getValue().isEmpty()) {
                    listNodeEntry = count.pollFirstEntry();
                }
                ListNode list = listNodeEntry.getValue();
                Node last = list.removeLast();
                if (!list.isEmpty()) {
                    count.put(last.count, list);
                }
                cache.remove(last.key);
            }
        } else {
            remove(n);
            n.count++;
        }
        n.val = value;
        ListNode listNode = count.getOrDefault(n.count, new ListNode());
        listNode.insertFirst(n);
        cache.put(n.key, n);
        count.put(n.count, listNode);
    }

    private void remove(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
        n.prev = null;
        n.next = null;
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4);
        System.out.println((cache.get(2)));
    }


}
