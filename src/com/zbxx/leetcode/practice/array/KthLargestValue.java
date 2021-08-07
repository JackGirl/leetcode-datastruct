package com.zbxx.leetcode.practice.array;


import com.sun.xml.internal.ws.api.ha.HaInfo;

import java.util.*;

/**
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 */
public class KthLargestValue {

    public static void main(String[] args) {
        int a[][] = {{10, 9, 5}, {2, 0, 4}, {1, 0, 9}, {3, 4, 8}};

        System.out.println(KthLargestValue(a, 10));
    }

    public static int KthLargestValue(int arr[][], int k) {
        int[] d = new int[arr.length * arr[0].length];
        Map<String, Integer> result = new HashMap<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int s = 0;
            for (int j = 0; j < arr[i].length; j++) {
                Integer preXor = result.getOrDefault((i - 1) + "," + j, 0);
                s = s ^ arr[i][j];
                result.put(i + "," + j, s ^ preXor);
                d[index++] = s ^ preXor;
            }
        }
        Arrays.sort(d);
        return d[d.length - k];
    }

}
