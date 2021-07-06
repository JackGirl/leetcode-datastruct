package com.zbxx.leetcode.contest.didi;


import java.util.Arrays;

/**
 * 第 50 场双周赛 每个查询的最大异或值
 */
public class getMaximumXor {


    static class TrieNode {
        int      val;
        TrieNode left;
        TrieNode right;

        public TrieNode(int val) {
            this.val = val;
        }

    }

    private void insert(TrieNode node, int val, int floor) {
        if (val == 1) {
            node.right = new TrieNode(1);
            node = node.right;
            if (floor > 0) {
                insert(node, 1, floor - 1);
                insert(node, 0, floor - 1);
            }

        } else {
            node.left = new TrieNode(0);
            node = node.left;
            if (floor > 0) {
                insert(node, 1, floor - 1);
                insert(node, 0, floor - 1);
            }
        }
    }

    /**
     * 时间在一秒就超时了  这里改了一下构建树的过程  k<2^maxbit次方  k最大值 2^maxbit-1  全为1   第一个1开始直接全部构建二叉树
     *
     * @param nums
     * @param maximumBit
     * @return
     */
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        TrieNode trieNode = new TrieNode(0);
        double maxK = Math.pow(2, maximumBit);
        int allxor = 0;
        for (int i = 0; i < nums.length; i++) {
            allxor ^= nums[i];
        }
        int maxLength = nums.length - 1;
        int kmax = ((Double) (maxK - 1)).intValue();
        TrieNode node = trieNode;
        for (int j = 30; j >= 0; j--) {
            int xor = (kmax >> j) & 1;
            if (xor == 1) {
                insert(node, xor, j);
                break;
            }
            node.left = new TrieNode(0);
            node = node.left;
        }

        int data[] = new int[nums.length];
        int idx = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            TrieNode n = trieNode;
            int result = 0;
            for (int j = 30; j >= 0; j--) {
                int r = (allxor >> j) & 1;
                if (r == 0) {
                    if (n.right != null) {
                        result = result * 2 + 1;
                        n = n.right;
                    } else {
                        result *= 2;
                        n = n.left;
                    }
                } else {
                    if (n.left != null) {
                        result = result * 2;
                        n = n.left;
                    } else {
                        result *= 2 + 1;
                        n = n.right;
                    }
                }

            }
            allxor ^= nums[maxLength--];
            data[idx++] = result;
        }
        return data;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getMaximumXor getMaximumXor = new getMaximumXor();
        int[] n = {0, 1, 2, 2, 5, 7};
        int maxBit = 3;
        System.out.println(Arrays.toString(getMaximumXor.getMaximumXor(n, maxBit)));

    }

}
