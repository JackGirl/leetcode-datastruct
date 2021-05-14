package com.zbxx.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchTree<K extends Comparable, V> {

    private Node<K, V> root;

    public SearchTree() {

    }

    public K put(K key, V value) {
        root = put(root, key, value);
        return key;
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value, null, null);
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            //右子树
            node.right = put(node.right, key, value);
        } else if (compare < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    /**
     * 删除节点保证查找树 将左节点替换（左节点最大） 没有左节点查找右子树最小节点
     *
     * @param key
     * @return
     */
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node<K, V> delete(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            //右子树
            node.right = delete(node.right, key);
        } else if (compare < 0) {
            node.left = delete(node.left, key);
        } else {
            //
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node<K, V> minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            K tempKey = minNode.key;
            V value = minNode.value;
            minNode.key = node.key;
            minNode.value = node.value;
            node.value = value;
            node.key = tempKey;
            node.right = delete(node.right, minNode.key);
            return node;
        }
        return node;
    }


    public V get(K key) {
        Node<K, V> node = get(root, key);
        return node == null ? null : node.value;
    }

    private Node<K, V> get(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            //右子树
            return get(node.right, key);
        } else if (compare < 0) {
            return get(node.left, key);
        } else {
            return node;
        }
    }

    public void printAll() {
        frontTree(root);
    }

    public void frontTree(Node<K, V> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        if (node.left != null) {
            frontTree(node.left);
        }
        if (node.right != null) {
            frontTree(node.right);
        }
    }


    public void deepTree() {
        Queue<Node<K, V>> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node<K, V> node = queue.poll();
            if (null == node) {
                return;
            }
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    class Node<K extends Comparable, V> {

        private K key;

        private V value;

        private Node<K, V> left;

        private Node<K, V> right;

        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        SearchTree<Integer, String> searchTree = new SearchTree();
        searchTree.put(12, "12");
        searchTree.put(4, "4");
        searchTree.put(17, "17");
        searchTree.put(2, "2");
        searchTree.put(8, "8");
        searchTree.put(9, "9");
        searchTree.put(6, "6");

        searchTree.put(7, "7");

        searchTree.printAll();

        System.out.println("===========");
        searchTree.delete(4);
        searchTree.printAll();
        System.out.println("===========");

        searchTree.deepTree();

    }


}
