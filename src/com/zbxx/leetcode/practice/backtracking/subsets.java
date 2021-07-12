package com.zbxx.leetcode.practice.backtracking;


import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * book 中级算法 回溯  子集
 */
public class subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> first = new LinkedList<>();
        result.add(new ArrayList<>(first));
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> item = new LinkedList<>();
            item.addLast(nums[i]);
            result.add(new LinkedList<>(item));
            backTracking(result, item, i + 1, nums);
        }
        return result;
    }

    public void backTracking(List<List<Integer>> result, LinkedList<Integer> item, int idx, int[] nums) {
        for (int i = idx; i < nums.length; i++) {
            item.add(nums[i]);
            result.add(new ArrayList<>(item));
            backTracking(result, item, i + 1, nums);
            item.pollLast();
        }
    }


    public static void main(String[] args) {
        subsets subsets = new subsets();
        System.out.println(StrUtil.toString(subsets.subsets(new int[]{1, 2, 3})));
    }
}
