package com.zbxx.leetcode.practice.design;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常数时间插入、删除和获取随机元素
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 */
public class RandomizedSet {

    List<Integer>         data  = new ArrayList<>();
    Map<Integer, Integer> keyMp = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!keyMp.containsKey(val)) {
            data.add(val);
            keyMp.put(val, data.size() - 1);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        Integer idx = keyMp.get(val);
        if (idx != null) {
            int last = data.get(data.size() - 1);
            int node = data.get(idx);
            data.set(idx, last);
            data.remove(data.size() - 1);
            keyMp.put(last, idx);
            keyMp.remove(node);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return data.get((int) Math.floor(Math.random() * data.size()));
    }


    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(0);
        set.insert(1);
        set.remove(0);
        set.insert(2);
        set.remove(1);
        System.out.println(set.getRandom());
    }


}



