package com.zbxx.sort;

import java.util.Arrays;

/**
 * @author: soft
 * <description></description>
 * @date: 2020/1/7
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 3, 6, 4, 5, 2, 0};
        int start = (arr.length - 1) / 2;
        for (int i = start; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
        //交换第一个和第i个 重新调整为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            System.out.println(Arrays.toString(arr));
            maxHeap(arr, i, 0);
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void maxHeap(int[] arr, int length, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        if (left < length && arr[left] > arr[max]) {
            max = left;
        }
        if (right < length && arr[right] > arr[max]) {
            max = right;
        }
        if (max != index) {
            swap(arr, max, index);
            maxHeap(arr, length, max);
        }
    }


    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


}
