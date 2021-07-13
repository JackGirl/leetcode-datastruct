package com.zbxx.leetcode.practice.array;


/**
 * book 中级算法排序 和搜索  查找数第一个位置和最后一个位置
 */
public class searchRange {


    /**
     * 我之前的做法是二分查找第一个数然后向后搜索
     * 这里用双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        boolean lf = false;
        boolean rf = false;
        while ((!lf || !rf) && l <= r) {
            if (!lf && nums[l] == target) {
                res[0] = l;
                lf = true;
            }
            if (!lf) {
                l++;
            }
            if (!rf && nums[r] == target) {
                res[1] = r;
                rf = true;
            }
            if (!rf) {
                r--;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        searchRange searchRange = new searchRange();
        searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
    }

}
