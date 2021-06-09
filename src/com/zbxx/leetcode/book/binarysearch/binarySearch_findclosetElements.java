package com.zbxx.leetcode.book.binarysearch;


import java.util.*;

/**
 * leetcode  book>二分查找
 */
public class binarySearch_findclosetElements {


    /**
     * [1,2,3,4,5,7,8,11,13,14]
     * 6
     * 11
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3};
        int k = 3, x = 3;
        System.out.println(Arrays.toString(findClosestElements(arr, k, x).toArray()));
    }


    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> s = new ArrayList<>();
        int l = 0;
        int mid;
        int r = arr.length - 1;

        //先找差值最小的
        while (l + 1 < r) {
            mid = l + (r - l) / 2;
            if (arr[mid] > x) {
                r = mid;
            }
            if (arr[mid] == x) {
                l = mid;
                break;
            }
            if (arr[mid] < x) {
                l = mid;
            }
        }

        if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
            l = r;
        }
        int ll = l - 1;
        int rr = l + 1;
        s.add(arr[l]);
        while (s.size() < k && ll >= 0 && rr < arr.length) {
            if (Math.abs(arr[ll] - x) <= Math.abs(arr[rr] - x)) {
                s.add(0, arr[ll--]);
            } else {
                s.add(arr[rr++]);
            }
        }
        if (s.size() < k) {
            for (int i = s.size(); i < k; i++) {
                if (rr > arr.length - 1) {
                    s.add(0, arr[ll--]);
                } else {
                    s.add(arr[rr++]);
                }
            }
        }
        return s;
    }


}


