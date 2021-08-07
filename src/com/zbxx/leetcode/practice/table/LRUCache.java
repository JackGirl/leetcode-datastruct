package com.zbxx.leetcode.practice.table;

import com.zbxx.T;

import java.util.HashMap;
import java.util.Map;

/**
 * book设计数据结构 146. LRU
 */
public class LRUCache {


    static class Node {

        int key;

        int val;

        Node prev;

        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }


    }

    Map<Integer, Node> cache = new HashMap<>();

    Node first;

    Node last;

    int maxSize;


    public LRUCache(int capacity) {
        this.first = new Node(-1, -1);
        this.last = new Node(-1, -1);
        maxSize = capacity;
        first.next = last;
        last.prev = first;
    }

    public int get(int key) {
        Node n = cache.get(key);
        if (n == null) {
            return -1;
        }
        n = remove(n);
        moveFirst(n);
        return n.val;
    }

    private Node remove(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
        n.prev = null;
        n.next = null;
        return n;
    }

    public void put(int key, int value) {
        Node n = cache.get(key);
        if (n == null) {
            n = new Node(key, value);
            if (maxSize == cache.size()) {
                Node rm = last.prev;
                remove(rm);
                cache.remove(rm.key);
            }
            cache.put(key, n);
        } else {
            remove(n);
        }
        moveFirst(n);
        n.val = value;
    }

    private void moveFirst(Node n) {
        Node next = first.next;
        first.next = n;
        n.prev = first;
        n.next = next;
        next.prev = n;
    }


}
