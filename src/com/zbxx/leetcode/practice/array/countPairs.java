package com.zbxx.leetcode.practice.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 大餐计数
 */
public class countPairs {


    public int countPairs(int[] deliciousness) {
        Map<Long, Integer> map = new HashMap<>();
        Arrays.sort(deliciousness);
        int sum = 0;
        int MOD = 1000000007;
        long max = deliciousness[deliciousness.length - 1] + deliciousness[deliciousness.length - 2];
        for (int i = 0; i < deliciousness.length; i++) {
            long bit;
            for (int j = 0; j <= deliciousness[deliciousness.length - 1]; j++) {
                bit = ((Double) Math.pow(2, j)).longValue();
                if (bit > max) {
                    break;
                }
                Integer num = map.getOrDefault(bit - deliciousness[i], 0);
                sum = (sum + num) % MOD;
            }
            map.put((long) deliciousness[i], map.getOrDefault((long) deliciousness[i], 0) + 1);
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new countPairs().countPairs(new int[]{0, 1}));
    }

}
