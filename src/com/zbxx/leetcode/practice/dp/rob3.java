package com.zbxx.leetcode.practice.dp;

import com.zbxx.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337 打家劫舍3
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class rob3 {

    Map<TreeNode, Integer> dp = new HashMap<>();


    /**
     * 我感觉leetcode 题目跟样式老是给的不明白 题意应该是偷当前节点 左右子节点就不能偷
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dp.containsKey(root)) {
            return dp.get(root);
        }
        int max = 0;
        if (root.left == null && root.right == null) {
            max = root.val;
        } else if (root.left != null && root.right != null) {
            int l = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right);
            max = Math.max(l, rob(root.left) + rob(root.right));
        } else {
            if (root.left == null) {
                max = Math.max(root.val + rob(root.right.left) + rob(root.right.right), rob(root.right));
            } else {
                max = Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left));
            }
        }
        dp.put(root, max);
        return max;
    }

}
