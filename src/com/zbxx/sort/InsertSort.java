package com.zbxx.sort;

import com.zbxx.util.ArrayUtils;

import java.util.Arrays;

public class InsertSort {


    public static void main(String[] args) {
        int arr[] = {9, 2, 32, 3, 8, 4, 6, 3, 2, 9, 0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 自己写出来第一遍 差点自己没理解感觉错了
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

}
