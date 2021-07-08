package com.zbxx.leetcode.practice.backtracking;


import cn.hutool.core.util.StrUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * book 中级算法 回溯 括号生成
 */
public class generateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        if (n == 0) {
            return result;
        }
        StringBuilder builder = new StringBuilder("(");
        trackBacking(result, builder, 1, 0, n, 1);
        return result;
    }

    public void trackBacking(List<String> result, StringBuilder builder, int l, int r, int maxSize, int step) {
        if (step == maxSize * 2) {
            result.add(builder.toString());
            return;
        }
        if (l > 0 && r < l && r < maxSize) {
            builder.append(")");
            trackBacking(result, builder, l, r + 1, maxSize, step + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (l < maxSize) {
            builder.append("(");
            trackBacking(result, builder, l + 1, r, maxSize, step + 1);
            builder.deleteCharAt(builder.length() - 1);
        }

    }


    public static void main(String[] args) {
        generateParenthesis generateParenthesis = new generateParenthesis();
        List<String> result = generateParenthesis.generateParenthesis(3);
        System.out.println(StrUtil.toString(result));
    }

}
