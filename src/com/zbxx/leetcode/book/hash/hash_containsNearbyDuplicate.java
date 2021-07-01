package com.zbxx.leetcode.book.hash;


import java.util.HashMap;
import java.util.Map;

/**
 * leetcode book hash 存在重复元素 II
 */
public class hash_containsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer preIndex = idxMap.get(nums[i]);
            if (preIndex == null) {
                idxMap.put(nums[i], i);
            } else {
                int r = i - preIndex;
                if (r <= k) {
                    return true;
                }
                idxMap.put(nums[i], i);
            }
        }
        return false;
    }

}
