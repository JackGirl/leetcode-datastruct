package com.zbxx.sort;

import java.util.Arrays;

public class MergeSort {


    private static int[] aux = new int[11];

    /**
     * @description :  左右 两边合并排序 start-end
     * @author :    万仁杰
     * @createDate : 15:21 2019/10/10
     * @modifyDate :
     */
    public static void merge(int arr[], int start, int mid, int end) {
        int lo = start;
        int j = mid + 1;
        for (int i = lo; i <= end; i++) {
            aux[i] = arr[i];
        }

        for (int i = lo; i <= end; i++) {
            if (j > end) {
                arr[i] = aux[lo++];
            } else if (lo > mid) {
                arr[i] = aux[j++];
            } else if (aux[lo] > aux[j]) {
                arr[i] = aux[j++];
            } else {
                arr[i] = aux[lo++];
            }
        }

    }

    public static void mergetSort(int[] arr, int left, int end) {
        if (left < end) {
            int newMid = (end + left) / 2;
            mergetSort(arr, left, newMid);
            mergetSort(arr, newMid + 1, end);
            merge(arr, left, newMid, end);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 32, 54, 3, 65, 8, 0, 9, 5, 911, 45};
        mergetSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
