package com.zbxx.leetcode.book.hash;


/**
 * leetcode book hash 设计hashmap
 */
public class hash_MyHashMap {

    static class Node {

        int key;

        int value;

        Node left;

        Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }


    }

    Node[] table;


    /**
     * Initialize your data structure here.
     */
    public hash_MyHashMap() {
        table = new Node[50];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = hash(key);
        if (table[hash] == null) {
            table[hash] = new Node(key, value);
            return;
        }
        Node node = table[hash];
        insert(node, key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return -1;
        }
        Node node = search(table[hash], key);
        return node == null ? -1 : node.value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return;
        }
        Node node = table[hash];
        table[hash] = delete(node, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }
        int cmp = key - node.key;
        if (cmp == 0) {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node min = node.right;
            while (min.left != null) {
                min = min.left;
            }
            int k = min.key;
            int v = min.value;
            min.key = node.key;
            min.value = node.value;
            node.key = k;
            node.value = v;
            node.right = delete(node.right, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            node.left = delete(node.left, key);
        }
        return node;
    }

    private int hash(int key) {
        return key % table.length;
    }

    private Node insert(Node node, int key, int value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key - node.key;
        if (cmp == 0) {
            node.value = value;
        } else if (cmp > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.left = insert(node.left, key, value);
        }
        return node;
    }

    private Node search(Node node, int key) {
        if (node == null) {
            return null;
        }
        int cmp = key - node.key;
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return search(node.right, key);
        } else {
            return search(node.left, key);
        }
    }

}
