package com.zbxx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 面试题 08.04 幂集
 */
public class subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new subsets().subsets(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(Arrays.toString(result.get(i).toArray()));
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> s = new ArrayList<List<Integer>>();
        s.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> t = new ArrayList<List<Integer>>(s);
            for (List<Integer> integers : t) {
                List<Integer> tt = new ArrayList<Integer>(integers);
                tt.add(nums[i]);
                s.add(tt);
            }
        }
        return s;
    }

}
