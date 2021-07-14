package com.zbxx.leetcode.practice.array;


import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 绝对差值和
 */
public class minAbsoluteSumDiff {


    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) 1e9 + 7;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        long sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum = (sum + Math.abs(nums1[i] - nums2[i]));
            queue.offer(new int[]{i, Math.abs(nums1[i] - nums2[i])});
        }
        Arrays.sort(nums1);
        //最大差值
        //最大差值都是零没必要找 直接返回
        int m = 0;
        while (!queue.isEmpty() && queue.peek()[1] > 0) {
            int[] max = queue.poll();
            int maxIdx = max[0];
            int maxSub = max[1];
            int n2 = nums2[maxIdx];
            //我们要找最接近n2的 找不到就下一个最大的
            int l = binarySearch(nums1, 0, nums1.length - 1, n2);
            int min = Math.abs(l - n2);
            if (min < max[1]) {
                m = Math.max(maxSub - min, m);
            }
        }
        return (int) ((sum - m) % mod);
    }


    private int binarySearch(int data[], int start, int end, int key) {
        int l = start;
        int r = end;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (data[mid] == key) {
                return data[mid];
            } else if (data[mid] < key) {
                l = mid;
            } else {
                r = mid;
            }
        }
        int d1 = Math.abs(key - data[l]);
        int d2 = Math.abs(key - data[r]);
        return d1 < d2 ? data[l] : data[r];
    }

    public static void main(String[] args) {
        minAbsoluteSumDiff m = new minAbsoluteSumDiff();
        int[] n1 = new int[]{5, 2, 7};
        int[] n2 = new int[]{10, 7, 12};
        System.out.println(m.minAbsoluteSumDiff(n1, n2));
    }


}
