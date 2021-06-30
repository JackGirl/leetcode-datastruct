package com.zbxx.leetcode.book.hash;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode book hash 设计hash集合
 */
public class hash_myHashSet {


    LinkedList<Integer>[] data;

    public hash_myHashSet() {
        data = new LinkedList[20];
    }

    public void add(int key) {
        int index = hash(key);
        if (data[index] == null) {
            data[index] = new LinkedList<>();
        }
        LinkedList<Integer> list = data[index];
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        if (data[index] == null) {
            return;
        }
        LinkedList<Integer> list = data[index];
        list.remove((Object) key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = hash(key);
        if (data[index] == null) {
            return false;
        }
        return data[index].contains((Object) key);
    }

    private int hash(int key) {
        return key % data.length;
    }


}
