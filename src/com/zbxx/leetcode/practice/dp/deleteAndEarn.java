package com.zbxx.leetcode.practice.dp;


/**
 * 740.删除并获得点数
 */
public class deleteAndEarn {


    /**
     * 给你一个整数数组nums，你可以对它进行一些操作。
     * <p>
     * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
     * <p>
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-and-earn
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int deleteAndEarn(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        int[] s = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            s[nums[i]] += nums[i];
        }
        int[] dp = new int[s.length];
        dp[1] = s[1];
        for (int i = 2; i < s.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + s[i]);
        }
        return dp[s.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
    }


}
