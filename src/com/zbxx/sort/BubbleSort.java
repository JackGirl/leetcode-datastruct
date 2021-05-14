package com.zbxx.sort;

import com.zbxx.util.ArrayUtils;

import java.util.Arrays;


public class BubbleSort {

    private static void bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    ArrayUtils.swap(array, j, j - 1);
                }
            }
        }
    }

    private static void frontBubble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    ArrayUtils.swap(array, j, j + 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {5, 3, 9, 1, 56, 23};
        System.out.println(Arrays.toString(array));
        frontBubble(array);
        System.out.println(Arrays.toString(array));
    }
}
