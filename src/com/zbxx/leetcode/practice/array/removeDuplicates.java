package com.zbxx.leetcode.practice.array;


/**
 * 删除排序数组中的重复项
 */
public class removeDuplicates {


    /**
     * 之前写过 发现这次写出来的跟以前的都不一样  哈哈
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int l = nums.length;
        int idx = 0;
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre) {
                l--;
                continue;
            } else {
                pre = nums[i];
                nums[idx++] = nums[i];
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] s = {1, 1, 2};
        removeDuplicates removeDuplicates = new removeDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(s));
        ;
    }

}
