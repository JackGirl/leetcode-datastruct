package com.zbxx.leetcode.practice.array;


import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 */
public class fourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (l > j + 1 && nums[l] == nums[l - 1]) {
                        l++;
                        continue;
                    }
                    if (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                        r--;
                        continue;
                    }
                    int s = nums[i] + nums[j] + nums[l] + nums[r];
                    if (s == target) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        result.add(item);
                        r--;
                        l++;
                    } else if (s < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] t = {-2, -1, -1, 1, 1, 2, 2};
        fourSum fourSum = new fourSum();
        System.out.println(StrUtil.toString(fourSum.fourSum(t, 0)));
    }

}
