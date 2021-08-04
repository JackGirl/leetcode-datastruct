package com.zbxx.leetcode.practice.dp;


import java.util.Arrays;
import java.util.List;

/**
 * 139 单词拆分 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class wordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean f[][] = new boolean[s.length() + 1][s.length() + 1];
        f[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (i <= j) {
                    String t = s.substring(i - 1, j);
                    if (wordDict.contains(t)) {
                        if (i > 1) {
                            if (f[1][i - 1]) {
                                f[1][j] = true;
                            }
                            f[i][j] = f[1][i - 1];
                        } else {
                            f[1][j] = true;
                        }
                    } else {

                    }
                }
            }
        }
        return f[1][s.length()];
    }



/*    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean f[] = new boolean[s.length()+1];
        f[0] = true;
        for (int i = 0; i <=s.length(); i++) {
            for (int j = 1; j <=s.length(); j++) {
                if(i<=j){
                    String t = s.substring(i,j);
                    if(wordDict.contains(t)){
                        if(i>0){
                            f[j] = f[j]||f[i];
                        }else{
                            f[j] = true;
                        }
                    }else{
                        f[j] = f[j];
                    }
                }
            }
        }
        return f[s.length()];
    }*/


    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> dict = Arrays.asList("apple", "pen", "t");
        System.out.println(wordBreak(s, dict));
    }

}
