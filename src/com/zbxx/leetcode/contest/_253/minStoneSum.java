package com.zbxx.leetcode.contest._253;

import java.util.PriorityQueue;

public class minStoneSum {


    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < piles.length; i++) {
            queue.offer(piles[i]);
        }
        while (k > 0 && !queue.isEmpty()) {
            int a = queue.poll();
            a = a - a / 2;
            if (a > 0) {
                queue.offer(a);
            }
            k--;
        }
        int s = 0;
        for (Integer integer : queue) {
            s += integer;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new minStoneSum().minStoneSum(new int[]{4, 3, 6, 7}, 3));
    }

}
