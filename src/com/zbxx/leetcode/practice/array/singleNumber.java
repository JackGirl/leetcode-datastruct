package com.zbxx.leetcode.practice.array;

import java.util.HashSet;
import java.util.Set;

public class singleNumber {

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 1, 0, 0, 0};
        int result = search(arr);
    }

    /**
     * 另了解了  hash法 还有32位/3 电路的那个解法不太理解
     *
     * @param arr
     * @return
     */
    private static int search(int[] arr) {
        int endIndex = arr.length - 1;
        Set<Integer> existSet = new HashSet<>();
        Set<Integer> singleSet = new HashSet<>();
        while (endIndex >= 0) {
            if (!existSet.contains(arr[endIndex])) {
                singleSet.add(arr[endIndex]);
                existSet.add(arr[endIndex]);
            } else {
                singleSet.remove(arr[endIndex]);
            }
            endIndex--;
        }
        return singleSet.iterator().next();
    }


}
