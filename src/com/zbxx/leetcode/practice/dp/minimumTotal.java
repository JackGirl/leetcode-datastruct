package com.zbxx.leetcode.practice.dp;

import java.util.List;

/**
 * 120 三角形最短路径和
 */

/**
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minimumTotal {


    /**
     * 这题从上往下 dp不行 因为前面还得依赖后面一层数据 不满足无后效性 而且下标处理复杂
     * 所以从下往上可以  最后一层固定 第一层固定   一层一层网上 min就行
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        int size = triangle.size();
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == size - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }


}
