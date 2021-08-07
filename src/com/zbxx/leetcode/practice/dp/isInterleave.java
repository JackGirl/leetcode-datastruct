package com.zbxx.leetcode.practice.dp;


/**
 * 97 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isInterleave {


    /**
     * 定义状态dp[i][j] 表示 s1前i个字符+ s2前i个字符能否匹配 s3前（i+j）个字符
     * i>0&&j>0 s3[i+j-1] 可以匹配s1[i-1] 也可以匹配s2[j-1] 其中一个可以 就说明匹配通过
     * i==0 和 j ==0  那么只匹配s1[i-1]或者s2[j-1] 需要前面匹配也是成功的 不然整体还是不成功
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0 && j > 0) {
                    if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                } else {
                    if (j > 0) {
                        dp[i][j] = dp[i][j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1);
                    }
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j] && s3.charAt(i - 1) == s1.charAt(i - 1);
                    }

                }
            }
        }
        return dp[s1.length()][s2.length()];
    }


    public static void main(String[] args) {
        System.out.println(new isInterleave().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
