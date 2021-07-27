package com.zbxx.leetcode.practice.tree;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * book设计数据结构 1707. 与数组中元素的最大异或值
 */
public class maximizeXor {

    static class TrieNode {

        TrieNode left;

        TrieNode right;

        int val;

        public TrieNode(int val) {
            this.val = val;
        }

        public TrieNode insert(int val) {
            if (val == 1) {
                if (this.right == null) {
                    this.right = new TrieNode(val);
                }
                return this.right;
            } else {
                if (this.left == null) {
                    this.left = new TrieNode(val);
                }
                return this.left;
            }
        }

    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        Map<int[], Integer> idxMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            idxMap.put(queries[i], i);
        }
        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int max[] = new int[queries.length];
        TrieNode root = new TrieNode(-1);
        int lastInsert = -1;
        boolean nodeNull = true;
        for (int i = 0; i < queries.length; i++) {
            max[idxMap.get(queries[i])] = -1;

            /**
             * 只添加新的数到前缀树  不然会超时
             */
            for (int j = lastInsert + 1; j < nums.length && nums[j] <= queries[i][1]; j++) {
                //建树
                TrieNode n = root;
                for (int k = 30; k >= 0; k--) {
                    n = n.insert((nums[j] >> k) & 1);
                }
                lastInsert = j;
                nodeNull = false;
            }
            if (nodeNull) {
                continue;
            }
            //查树
            TrieNode n = root;
            int r = 0;
            for (int j = 30; j >= 0; j--) {
                int xor = (queries[i][0] >> j) & 1;
                if (xor == 1) {
                    if (n.left != null) {
                        n = n.left;
                        r = r * 2 + 1;
                    } else {
                        n = n.right;
                        r *= 2;
                    }
                } else {
                    if (n.right != null) {
                        n = n.right;
                        r = r * 2 + 1;
                    } else {
                        n = n.left;
                        r *= 2;
                    }
                }
            }
            max[idxMap.get(queries[i])] = Math.max(max[idxMap.get(queries[i])], r);
        }
        return max;
    }

}
