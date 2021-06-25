package com.zbxx.leetcode.book.bst;


import com.zbxx.leetcode.struct.TreeNode;

/**
 * leetcode book bst 数据流中第K大的数
 */
public class bst_KthLargest {

    TreeNode root;

    int k;

    TreeNode kNode;

    public static class TreeNode {
        int val;

        int count = 1;

        TreeNode left;

        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public bst_KthLargest(int k, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
        this.k = k;
    }

    public int add(int val) {
        root = insert(root, val);
        if (kNode != null && val <= kNode.val) {
            return kNode.val;
        } else {
            kNode = findKNode(root, k);
        }
        return kNode.val;
    }

    private TreeNode findKNode(TreeNode node, int len) {
        int rc = nodeCount(node.right);
        if (rc + 1 == len) {
            return node;
        }
        if (rc >= len) {
            return findKNode(node.right, len);
        }
        return findKNode(node.left, len - rc - 1);
    }


    public int nodeCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.count;

    }


    public TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        int cmp = val - node.val;
        if (cmp <= 0) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        node.count++;
        return node;
    }


    public static void main(String[] args) {
        bst_KthLargest kthLargest = new bst_KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);
    }


}
