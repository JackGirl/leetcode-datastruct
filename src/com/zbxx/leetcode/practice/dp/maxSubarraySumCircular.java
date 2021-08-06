package com.zbxx.leetcode.practice.dp;


/**
 * 918 环形子数组的最大值
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * <p>
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 * <p>
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-circular-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxSubarraySumCircular {

    /**
     * 评论区解法  dp
     * 需要用到环 因为每个元素只能选一次 且最少选一个
     * 那么最大值 等于 数组sum-其中最小的一段 然后比较两种较大的一种
     * 如果 不用环最大值都小于零  那么 直接返回第一种  不然第二种 减一下 大于零得
     *
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0];
        int min = sum;
        int max = sum;
        int minPre = sum;
        int maxPre = sum;
        for (int i = 1; i < nums.length; i++) {
            maxPre = Math.max(nums[i] + maxPre, nums[i]);
            minPre = Math.min(nums[i] + minPre, nums[i]);
            max = Math.max(max, maxPre);
            min = Math.min(min, minPre);
            sum += nums[i];
        }
        if (max < 0) {
            return max;
        } else {
            return Math.max(max, sum - min);
        }
    }


    /**
     * 我的最开始解法 滑动窗口 O（n^2）  低分飘过
     *
     * @param args
     */
/*
    public int maxSubarraySumCircular(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int pre = nums[0];
        int max = nums[0];
        int size = 1;
        for (int i = 0; i <nums.length ; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length-1; i++) {
            list.add(nums[i]);
        }
        for (int i = 1; i < list.size(); i++) {
            if(size == nums.length){
                size--;
                if(size>0){
                    pre -= list.get(i-size-1);
                }
                int t =  0;
                for (int j =i-size; j < i; j++) {
                    t+=list.get(j);
                    if(pre-t>pre){
                        size =  i-j-1;
                        pre-=t;
                        t=0;
                    }
                }
            }
            int c = list.get(i);

            if(pre+c>c){
                pre+=c;
                size++;
            }else{
                pre = c;
                size = 1;
            }
            max = Math.max(pre,max);
        }
        return max;
    }*/
    public static void main(String[] args) {
        System.out.println(new maxSubarraySumCircular().maxSubarraySumCircular(new int[]{5, -3, 5}));
    }


}
