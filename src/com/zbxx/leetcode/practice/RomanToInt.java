package com.zbxx.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {


    public static void main(String[] args) {
        String s = "IX";

        System.out.println(roman2Int(s));
    }

    public static int roman2Int(String s) {
        Map<Character, Integer> charaterMap = new HashMap<>(12);
        charaterMap.put('I', 1);
        charaterMap.put('V', 5);
        charaterMap.put('X', 10);
        charaterMap.put('L', 50);
        charaterMap.put('C', 100);
        charaterMap.put('D', 500);
        charaterMap.put('M', 1000);
        char[] arr = s.toCharArray();
        int t = charaterMap.get(s.charAt(arr.length - 1));
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int a1 = charaterMap.get(arr[i]);
            if (a1 < t) {
                sum += -a1;
            } else {
                sum += a1;
            }
            t = a1;
        }

        return sum;
    }


}
