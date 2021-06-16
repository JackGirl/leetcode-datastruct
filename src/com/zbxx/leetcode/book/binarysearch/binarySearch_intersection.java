package com.zbxx.leetcode.book.binarysearch;


import java.util.*;

/**
 * leetcode book>二分查找  找数组交集
 */
public class binarySearch_intersection {


    public static void main(String[] args) {
        int[] n1 = {1, 2, 2, 1};
        int[] n2 = {2, 2};
        System.out.println(Arrays.toString(intersection2(n1, n2)));
    }


    /**
     * 快点做法就是直接hash 表存储获取
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> stack = new LinkedHashSet<>();
        int[] t = nums1.length > nums2.length ? nums2 : nums1;
        int[] longAr = t == nums1 ? nums2 : nums1;
        Arrays.sort(t);
        int index;
        for (int i = 0; i < longAr.length; i++) {
            index = Arrays.binarySearch(t, longAr[i]);
            if (index >= 0) {
                stack.add(longAr[i]);
            }
        }
        int[] result = new int[stack.size()];
        int idx = 0;
        for (Integer a : stack) {
            result[idx++] = a;
        }
        return result;
    }


    public static int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0;
        int r = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] == nums2[r]) {
                linkedList.add(nums1[l]);
                l++;
                r++;
                continue;
            }
            if (nums1[l] < nums2[r]) {
                l++;
            } else {
                r++;
            }
        }
        int[] result = new int[linkedList.size()];
        int idx = 0;
        for (Integer a : linkedList) {
            result[idx++] = a;
        }
        return result;
    }


}
