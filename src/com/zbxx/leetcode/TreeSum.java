package src.com.zbxx.leetcode;

import java.util.*;

public class TreeSum {


    public static void main(String[] args) {

        int[] arr = {-2, 0, 3, -1, 4, 0, 3, 4, 1, 1, 1, -3, -5, 4, 0};
        System.out.println(search(arr));
    }

    public static List<List<Integer>> search(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> collection = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > 0) {
                return collection;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int left = i + 1;
            int high = arr.length - 1;
            while (left < high) {
                int t = arr[left] + arr[i] + arr[high];
                if (t == 0) {
                    List<Integer> s = new ArrayList<>();
                    s.add(arr[i]);
                    s.add(arr[left]);
                    s.add(arr[high]);
                    collection.add(s);
                    while (arr[left] == arr[left + 1]) {
                        left++;
                    }
                    left++;
                    while (arr[high] == arr[high - 1]) {
                        high--;
                    }
                    high--;
                } else if (t > 0) {
                    if (arr[high] == arr[high - 1]) {
                        high--;
                    }
                    high--;
                } else if (t < 0) {
                    if (arr[left] == arr[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        return collection;
    }


}
