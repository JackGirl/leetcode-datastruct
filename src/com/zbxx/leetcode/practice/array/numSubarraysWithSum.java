package com.zbxx.leetcode.practice.array;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 和相同的二元子数组
 */
public class numSubarraysWithSum {


    /**
     * 具体思路是   比如 00100  如果和为1  前面去掉0 后面和为1 的可能性为最后一位1后面的0数目并且需要加上1 一个截止到最后一的数   比如0100  010  和 01
     * 还有一个特殊的情况就是全为000  那么没有1  到1的数显然不用加  000  去掉一位 00  +2  再去掉一位 加1  直到队列为空 或者去掉的数为1
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int r = 0;
        int zeroNum = 0;
        boolean full = false;
        Deque<Integer> deque = new LinkedList<>();
        for (int num : nums) {
            if (num == 1 && sum == goal) {
                if (zeroNum == deque.size()) {
                    full = true;
                }
                while (!deque.isEmpty()) {
                    Integer poll = deque.pollFirst();
                    if (poll == 0) {
                        if (full) {
                            zeroNum--;
                        }
                        if (!full) {
                            r++;
                        }
                        r += zeroNum;
                    } else {
                        sum -= 1;
                        break;
                    }
                }
            }
            if (sum + num == goal) {
                r++;
            }
            if (num == 0) {
                zeroNum++;
            } else {
                zeroNum = 0;
            }
            deque.addLast(num);
            sum += num;
            while (sum > goal) {
                sum -= deque.pollFirst();
            }
            full = false;
        }
        if (zeroNum == deque.size()) {
            full = true;
        }
        while (!deque.isEmpty() && sum == goal) {
            Integer poll = deque.pollFirst();
            if (poll == 0) {
                if (full) {
                    zeroNum--;
                }
                if (!full) {
                    r++;
                }
                r += zeroNum;
            } else {
                break;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        numSubarraysWithSum numSubarraysWithSum = new numSubarraysWithSum();
        System.out.println(numSubarraysWithSum.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 0));
    }


}
