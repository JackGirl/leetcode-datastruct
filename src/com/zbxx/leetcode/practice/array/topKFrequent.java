package com.zbxx.leetcode.practice.array;


import java.util.*;

/**
 * 前K个高频元素
 */
public class topKFrequent {


    /**
     * 题目 是要求 小于nlogn时间复杂度  这里是 2n+K 通过
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> group = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            group.put(nums[i], group.getOrDefault(nums[i], 0) + 1);
        }
        TreeMap<Integer, LinkedList<Integer>> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : group.entrySet()) {
            LinkedList<Integer> linkedList = treeMap.getOrDefault(entry.getValue(), new LinkedList<>());
            linkedList.add(entry.getKey());
            treeMap.put(entry.getValue(), linkedList);
        }
        int idx = 0;
        while (idx < k) {
            LinkedList<Integer> linkedList = treeMap.pollLastEntry().getValue();
            for (Integer integer : linkedList) {
                if (idx < k) {
                    res[idx++] = integer;
                } else {
                    break;
                }
            }
        }
        return res;
    }


}
