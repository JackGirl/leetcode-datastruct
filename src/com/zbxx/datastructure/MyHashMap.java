package com.zbxx.datastructure;

import lombok.Data;

import java.util.Map;

/**
 * hashMao 红黑树
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K extends Comparable, V> {


    @Data
    static class ListNode<K extends Comparable, V> implements Map.Entry<K, V> {

        K k;

        V v;

        ListNode<K, V> next;

        public ListNode(K k, V v) {
            this.k = k;
            this.v = v;
        }


        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }
    }

    @Data
    static class TreeNode<K extends Comparable, V> implements Map.Entry<K, V> {

        K k;

        V v;

        boolean red;

        TreeNode<K, V> parent;

        TreeNode<K, V> left;

        TreeNode<K, V> right;

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }


    }

    /**
     * 数据
     */
    Map.Entry<K, V>[] table;
    /**
     * 默认大小
     */
    final static Integer DEFAULT_CAPACITY = 16;
    /**
     * 树节点转链表大小
     */
    final static Integer TREE_2_NODE      = 6;
    /**
     * 节点转树大小
     */
    final static Integer NODE_2_TREE      = 8;
    /**
     * elementSize
     */
    int size;


    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int initCapacity) {
        int capacity = initCapacity <= 0 ? DEFAULT_CAPACITY : initCapacity;
        table = new Map.Entry[initCapacity];
    }

    private int index(K key) {
        return (key == null) ? 0 : key.hashCode() % table.length;
    }


    private void resize() {
    }


    public boolean containsKey(K k) {
        return get(k) != null;
    }

    public V put(K k, V v) {
        return v;
    }

    public V get(K k) {
        return null;
    }

    public boolean remove(K k) {
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    Iterable<K> keys() {
        return null;
    }


}
