package com.zbxx.leetcode.practice.backtracking;


import cn.hutool.core.util.StrUtil;

import java.util.*;

/**
 * book 中级算法 回溯  全排列
 */
public class permute {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        for (int num : nums) {
            LinkedList<Integer> item = new LinkedList<>();
            treeSet.remove(num);
            item.addLast(num);
            trackBacking(result, item, treeSet, nums.length);
            treeSet.add(num);
        }
        return result;
    }

    public void trackBacking(List<List<Integer>> result, LinkedList<Integer> item, TreeSet<Integer> select, int maxSize) {
        if (item.size() == maxSize) {
            result.add(new ArrayList<>(item));
            return;
        }
        Integer[] array = new Integer[select.size()];
        select.toArray(array);
        for (Integer integer : array) {
            item.addLast(integer);
            select.remove(integer);
            trackBacking(result, item, select, maxSize);
            item.removeLast();
            select.add(integer);
        }

    }


    public static void main(String[] args) {
        permute permute = new permute();
        System.out.println(StrUtil.toString(permute.permute(new int[]{1, 2, 4, 5})));
    }


}
