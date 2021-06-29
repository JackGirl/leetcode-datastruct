package com.zbxx.leetcode.book.trie;


/**
 * leetcode book trie  最大异或值
 */
public class trie_findMaximumXOR {

    TreeNode root = new TreeNode(0);

    static class TreeNode {

        int val;

        //0
        TreeNode left;
        //1
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public int findMaximumXOR(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        TreeNode first = root;
        for (int i = 30; i >= 0; i--) {
            System.out.print((arr[0] >> i) & 1);
            first = insert(first, (arr[0] >> i) & 1);
        }
        System.out.println();
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            TreeNode node = root;
            TreeNode n = root;
            int result = 0;
            for (int j = 30; j >= 0; j--) {
                int r = (arr[i] >> j) & 1;
                System.out.print(r);
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
                        result = result * 2 + 1;
                        n = n.left;
                    } else {
                        result *= 2;
                        n = n.right;
                    }
                }
                node = insert(node, r);
            }
            System.out.println();
            max = Math.max(max, result);
        }
        return max;
    }


    public TreeNode insert(TreeNode root, int val) {
        if (val == 0) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            }
            return root.left;
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            }
            return root.right;
        }
    }

    public static void main(String[] args) {
        trie_findMaximumXOR findMaximumXOR = new trie_findMaximumXOR();
        System.out.println(findMaximumXOR.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }


}
