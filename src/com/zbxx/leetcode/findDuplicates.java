package com.zbxx.leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 442 数组中重复的数据
 */
public class findDuplicates {


    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i])) {
                arr.add(nums[i]);
            }
            s.add(nums[i]);
        }
        return arr;
    }

}
