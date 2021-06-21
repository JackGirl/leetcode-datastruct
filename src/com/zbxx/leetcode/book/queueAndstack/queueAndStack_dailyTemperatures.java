package com.zbxx.leetcode.book.queueAndstack;


import java.util.*;

/**
 * leetcode book queueAndStack 每日温度  [73,74,75,71,69,72,76,73]
 */
public class queueAndStack_dailyTemperatures {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 74, 71, 69, 72, 76, 73})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int r[] = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                Integer t = stack.peek();
                if (temperatures[i] > temperatures[t]) {
                    r[t] = i - t;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        return r;
    }


}
