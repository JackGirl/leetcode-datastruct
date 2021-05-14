package com.zbxx.leetcode;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 股票卖出最佳时机
 */
public class MaxProfit {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("txt.txt").getPath()));
        List<Integer> prices = new ArrayList<>();
        String s;
        while ((s = reader.readLine()) != null && s != "") {
            prices.add(Integer.valueOf(s));
        }
        int min = prices.get(0);
        int max = 0;
        for (int i = 1; i < prices.size(); i++) {
            max = Math.max(max, prices.get(i) - min);
            min = Math.min(min, prices.get(i));
        }
        System.out.println(max);
    }


}
