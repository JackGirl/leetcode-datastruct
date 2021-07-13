package com.zbxx.leetcode.practice.array;


/**
 * 寻找数组第K大的数
 */
public class findKthLargest {


    /**
     * 偷懒做法直接排序 arr[arr.length-k] 题目考察的肯定不是这个
     * 构建堆  只要构建K次
     * 快排 更快 不需要完整排序
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int r = fastSort(nums, 0, nums.length - 1, k);
        return r;
    }

    private int fastSort(int[] nums, int l, int r, int k) {
        int t = nums[l];
        int right = r;
        int left = l;
        while (l < r) {
            while (r >= l && nums[r] >= t) {
                r--;
            }
            if (r > l) {
                nums[l++] = nums[r];
            }
            while (l <= r && nums[l] < t) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }
        }
        if (l == r) {
            nums[l] = t;
        }
        int o = right - l + 1;
        if (o > k) {
            return fastSort(nums, l + 1, right, k);
        } else if (o == k) {
            return nums[l];
        } else {
            return fastSort(nums, left, l - 1, k - o);
        }
    }


}
