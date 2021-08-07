package com.zbxx.leetcode.practice.dfs;


import java.util.*;

public class circularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        TreeSet<Integer> notVisited = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            notVisited.add(i);
        }
        Set<Integer> notContains = new HashSet<>();
        LinkedHashSet<Integer> set = new LinkedHashSet();

        int idx = 0;
        while (!notVisited.isEmpty()) {
            while (!notVisited.isEmpty() && (!notContains.contains(idx) && !set.contains(idx))) {
                notVisited.remove(idx);
                set.add(idx);
                idx = getNextIdx(idx, nums);
            }
            if (set.contains(idx)) {
                boolean find = false;
                boolean sign = true;
                int size = 0;
                for (Integer integer : set) {
                    if (find) {
                        size++;
                        if ((sign && nums[integer] < 0) || (!sign && nums[integer] > 0)) {
                            find = false;
                            break;
                        }
                    }
                    if (integer == idx) {
                        find = true;
                        sign = nums[idx] > 0;
                    }
                }
                if (find && size > 0) {
                    return true;
                }
            }
            notContains.addAll(set);
            set.clear();
            if (!notVisited.isEmpty()) {
                idx = notVisited.pollFirst();
            }
        }
        return false;
    }

    private int getNextIdx(int idx, int[] nums) {
        int next = idx + nums[idx];
        if (next < nums.length && next >= 0) {
            return next;
        } else {
            if (nums[idx] > 0) {
                return (next % nums.length);
            }
            next = Math.abs(next + 1);
            return nums.length - 1 - (next % nums.length);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 100, 223, -788, 1000};
        System.out.println(new circularArrayLoop().circularArrayLoop(nums));
    }


}
