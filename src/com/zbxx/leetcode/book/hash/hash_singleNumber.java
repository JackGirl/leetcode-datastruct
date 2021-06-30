package com.zbxx.leetcode.book.hash;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode book hash 只出现一次的数字
 */
public class hash_singleNumber {


    /**
     * @param nums
     * @return
     */
 /*   public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            Integer s = map.getOrDefault(nums[i],0);
            map.put(nums[i],++s);
        }
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : set) {
            if(integerIntegerEntry.getValue()==1){
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
    }*/
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Set<Integer> map = new HashSet<>();
        Set<Integer> dep = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.add(nums[i]) || dep.contains(nums[i])) {
                map.remove(nums[i]);
                dep.add(nums[i]);
            }
        }
        for (Integer integer : map) {
            return integer;
        }
        return -1;
    }


}
