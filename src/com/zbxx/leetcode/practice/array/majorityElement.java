package com.zbxx.leetcode.practice.array;

import java.util.HashMap;
import java.util.Map;

public class majorityElement {


    /**
     * 分治 ： 左右众数数量最大的
     * 摩尔投票
     * 排序后 中位数就是众数
     * 随机选一个数 检查
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> s = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            s.put(nums[i], s.getOrDefault(nums[i], 0) + 1);
            if (s.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }

}
