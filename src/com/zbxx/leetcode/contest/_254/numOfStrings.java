package com.zbxx.leetcode.contest._254;

public class numOfStrings {


    /**
     * 简单题 没啥说的
     *
     * @param patterns
     * @param word
     * @return
     */
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String p : patterns) {
            if (p.length() > word.length()) {
                continue;
            }
            if (word.indexOf(p) != -1) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new numOfStrings().numOfStrings(new String[]{"a", "abc", "bc", "d"}, "abc"));
    }

}
