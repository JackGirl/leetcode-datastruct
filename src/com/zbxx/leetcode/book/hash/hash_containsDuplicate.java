package com.zbxx.leetcode.book.hash;


import java.util.HashSet;
import java.util.Set;

/**
 * leetcode book hash 存在重复元素
 */
public class hash_containsDuplicate {


    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                continue;
            }
            return true;
        }
        return false;
    }

}
