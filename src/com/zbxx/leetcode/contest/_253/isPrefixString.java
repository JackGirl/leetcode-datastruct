package com.zbxx.leetcode.contest._253;

public class isPrefixString {

    public boolean isPrefixString(String s, String[] words) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            builder.append(words[i]);
            String t = builder.toString();
            if (t.equals(s)) {
                return true;
            }
            if (t.length() >= s.length()) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new isPrefixString().isPrefixString("iloveleetcode", new String[]{"apples", "i", "love", "leetcode"}));
    }

}
