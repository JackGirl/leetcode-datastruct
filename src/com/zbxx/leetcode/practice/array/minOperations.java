package com.zbxx.leetcode.practice.array;


import java.util.HashMap;
import java.util.Map;

/**
 * 每日一题 1713 。 得到子序列的最少操作数
 */
public class minOperations {


    /**
     * 在arr任意位插入数使target为arr子序列  位置可以不连续
     * 首先想到的是 从arr找target 的最长子序列  但是动态规划是n^2 本题10^5次方数超时
     * 看官方题解思路  有一个贪心加二分
     * 映射hash 是为了查找子序列时  保持在target的顺序  如果target.length = 6 最长顺序子序列 3  那么只需要插入三个数就能得到target  最小操作数就是 6-3  target.length - maxSubArr
     *
     * @param target
     * @param arr
     * @return
     */
    public static int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            idxMap.put(target[i], i);
        }
        int[] tr = new int[target.length + 1];
        int len = 0;
        for (int i : arr) {
            if (idxMap.containsKey(i)) {
                int idx = idxMap.get(i);
                int search = binarySearch(tr, idx, len);
                if (search == len) {
                    tr[++len] = idx;
                } else {
                    tr[search + 1] = idx;
                }
            }
        }
        return target.length - len;
    }


    public static int binarySearch(int[] tr, int idx, int right) {
        if (right == 0 || tr[right] < idx) {
            return right;
        }
        int l = 0;
        int r = right;
        while (l + 1 < r) {
            int mid = (l + (r - l) / 2);
            if (tr[mid] < idx) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (tr[r] < idx) {
            return r;
        } else {
            return l;
        }
    }

    public static void main(String[] args) {
        int[] target = {5, 1, 3};
        int[] arr = {9, 4, 2, 3, 4};
        System.out.println(minOperations(target, arr));
    }


}
