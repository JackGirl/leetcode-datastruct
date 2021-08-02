package com.zbxx.leetcode.practice.tree;


import com.zbxx.leetcode.struct.TreeNode;

/**
 * 二叉树最大路径和
 */
public class MaxPathSum {


    //[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(9);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(-3);
        treeNode.left.left = new TreeNode();
        treeNode.left.right = new TreeNode();
        treeNode.right.left = new TreeNode(-6);
        treeNode.right.right = new TreeNode(2);

        treeNode.left.left.left = new TreeNode();
        treeNode.left.left.right = new TreeNode();
        treeNode.left.right.left = new TreeNode(2);
        treeNode.left.right.right = new TreeNode();

        treeNode.right.left.left = new TreeNode();
        treeNode.right.left.right = new TreeNode(-6);
        treeNode.right.right.left = new TreeNode(-6);


        int[] arr = new int[1];
        arr[0] = Integer.MIN_VALUE;
        maxPath(treeNode, arr);
        System.out.println(arr[0]);
    }


    public static int maxPath(TreeNode root, int maxArr[]) {
        int leftSum = 0;
        int rightSum = 0;
        int max;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            leftSum = maxPath(root.left, maxArr);
        }
        if (root.right != null) {
            rightSum = maxPath(root.right, maxArr);
        }
        max = Math.max(leftSum, rightSum);
        if (leftSum < 0 || rightSum < 0) {
            if (root.val > 0 && max >= 0) {
                maxArr[0] = Math.max(maxArr[0], root.val + max);
            } else {
                max = Math.max(root.val, root.val + max);
                maxArr[0] = Math.max(maxArr[0], root.val);
                return max;
            }
        } else {
            maxArr[0] = Math.max(root.val + leftSum + rightSum, maxArr[0]);
        }
        return root.val + max;
    }


}
