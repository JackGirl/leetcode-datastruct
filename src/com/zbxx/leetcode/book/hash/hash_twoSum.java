package com.zbxx.leetcode.book.hash;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * leetcode book hash 两数之和
 */
public class hash_twoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] r = new int[2];
        r[0] = -1;
        r[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            Integer idx = map.get(sub);
            if (idx != null && idx != i) {
                r[0] = i;
                r[1] = map.get(sub);
                break;
            }
            ;
        }
        return r;
    }

    public static void main(String[] args) {
        hash_twoSum twoSum = new hash_twoSum();
        twoSum.twoSum(new int[]{3, 3}, 6);

    }

}
