package com.zbxx.leetcode.practice.array;


import java.util.Arrays;

/**
 * 611有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 */
public class triangleNumber {


    /**
     * 这题直接按照三数之和的套路就行 并且数据只要下标不同就添加到结果
     * 朴素解法  三层for
     * 然后排序之后 比如 当前r=c  c>a c>b  ab>c  那么在c之前的都满足 c1<c c1>a c1>b a+b>c1
     * 所以用二分找到右边的最后一个满足的 n2logn
     *
     * @param nums
     * @return
     */
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int t = nums[j] + nums[i];
                int r = nums.length - 1;
                int l = j;
                int mid;
                while (l + 1 < r) {
                    mid = l + (r - l) / 2;
                    if (t > nums[mid]) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                if (t > nums[r]) {
                    ans += r - j;
                } else {
                    ans += r - l;
                }
            }
        }
        return ans;
    }
//题解区大神的解法   固定最长边  O(n2)
/*    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int k = 0;
            int j = i - 1;
            while (k < j) {
                //满足该条件，说明从num[k]到num[j]的数都满足要求，结果直接加上j - k
                if (nums[k] + nums[j] > nums[i]) {
                    result += j - k;
                    j--;
                } else {
                    //否则k自增，重新判断
                    k++;
                }
            }
        }
        return result;
    }*/

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(triangleNumber(nums));
    }


}
