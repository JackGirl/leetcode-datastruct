package com.zbxx.sort;

import java.util.Arrays;

public class MergeSort {


    /**
     * @description :  左右 两边合并排序 start-end
     * @author :    万仁杰
     * @createDate : 15:21 2019/10/10
     * @modifyDate :
     */
    public static void merge(int arr[], int start, int mid, int end) {
        int data[] = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                data[index++] = arr[left++];
                continue;
            }
            data[index++] = arr[right++];
        }
        while (right <= end) {
            data[index++] = arr[right++];
        }
        while (left <= mid) {
            data[index++] = arr[left++];
        }
        for (int i = 0; i < data.length; i++) {
            arr[start + i] = data[i];
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
        int[] arr = {1, 32, 54, 3, 65, 8, 0, 9};
        mergetSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
