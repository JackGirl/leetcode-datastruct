package com.zbxx.leetcode.practice.array;


/**
 * 搜索旋转排序数组
 */
public class search {


    /**
     * 之前已经做过 重新回顾下
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[l] > nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target < nums[l] && nums[mid] >= nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }


    public static void main(String[] args) {
        search search = new search();
        int[] nums = new int[]{3, 1};
        int res = search.search(nums, 1);
        System.out.println(res);
    }


}
