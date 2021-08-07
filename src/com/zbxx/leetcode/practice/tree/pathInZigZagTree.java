package com.zbxx.leetcode.practice.tree;

import java.util.LinkedList;
import java.util.List;


/**
 * 每日一题 1104 二叉树寻路
 */
public class pathInZigZagTree {


    /**
     * 我是根据左边节点数来从上往下一层层搜
     * 官方答案 太巧妙了  偶数层翻转    翻转后的值加原来的值 等于当前层起始编号加最大编号 减去翻转后的  就是翻转前的编号了
     * 又因为是满二叉树  子节点val/2就是父节点值 就可以推出上一层   真是妙
     *
     * @param label
     * @return
     */

    public List<Integer> pathInZigZagTree(int label) {
        boolean[] left = new boolean[1];
        int[] variable = new int[4];
        variable[0] = 1;
        left[0] = true;
        List<Integer> ans = new LinkedList<>();
        int start = 1;
        int f = calculateFloor(label);
        int nAll = (int) Math.pow(2, f - 1);
        // 到n层时为根节点 label 距离左边有多少个节点
        variable[2] = nAll / 2;
        //上面层节点总数
        int t = (int) (Math.pow(2, f - 1) - 1);
        if (f % 2 == 0) {
            //偶数从右开始
            if (f > 0) {
                variable[3] = nAll - (label - t);
            }
        } else {
            variable[3] = label - t - 1;
        }
        while (true) {
            ans.add(start);
            if (start == label) {
                return ans;
            }
            start = getNextLabel(left, variable);
        }
    }

    public int getNextLabel(boolean[] left, int[] variable) {
        left[0] = !left[0];
        int ans;
        int all = (int) (Math.pow(2, variable[0]) - 1);
        int nextAll = (int) Math.pow(2, variable[0]);
        //往右节点找
        if (variable[2] <= variable[3]) {
            //到当前层为止节点总数
            if (left[0]) {
                ans = all + (variable[1] * 2 + 2);
            } else {
                ans = nextAll + all - (variable[1] * 2 + 1);
            }
            variable[3] -= variable[2];
            variable[2] /= 2;
            variable[1] = 2 * variable[1] + 1;
        } else {
            if (left[0]) {
                ans = all + (variable[1] * 2 + 1);
            } else {
                ans = nextAll + all - (variable[1] * 2);
            }
            variable[2] /= 2;
            variable[1] *= 2;
        }
        variable[0]++;
        return ans;
    }

    public int calculateFloor(int label) {
        long f = 1;
        long r = 2;
        while (r < label) {
            r *= 2;
            f++;
        }
        return (int) f;
    }


}
