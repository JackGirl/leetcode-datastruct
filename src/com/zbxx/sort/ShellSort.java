package src.com.zbxx.sort;

import src.com.zbxx.util.ArrayUtils;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {1, 32, 54, 3, 65, 8, 0, 9, 11, 23, 79, 0, 6, 56};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void shellSort(int[] arr) {
        int r = arr.length % 2;
        r = r == 0 ? 1 : r;
        int h = arr.length / 2 + r;

        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                // j-h  主要是处理边界 交换
                for (int j = i; j >= h; j -= h) {
                    System.out.println("group :" + arr[j] + " " + arr[j - h]);
                    if (arr[j] < arr[j - h]) {
                        ArrayUtils.swap(arr, j, j - h);
                    }
                    System.out.println(Arrays.toString(arr));
                }

            }
            h = h / 2;

        }

    }

}
