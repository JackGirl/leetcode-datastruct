package com.zbxx.leetcode;

import java.util.*;

public class IsCousins {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode();
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(isCousins(root, 4, 7));
    }


    public static boolean isCousins(TreeNode root, int x, int y) {
        int depth = 0;
        Map<Integer, int[]> map = new HashMap<>();
        int arr[] = new int[2];
        arr[0] = depth;
        arr[1] = root.val;
        map.put(root.val, arr);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            int[] d = map.get(treeNode.val);
            int ar1[] = new int[2];
            ar1[0] = d[0] + 1;
            ar1[1] = treeNode.val;
            if (treeNode.left != null) {
                queue.add(treeNode.left);
                map.put(treeNode.left.val, ar1);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
                map.put(treeNode.right.val, ar1);
            }
        }
        int[] ar1 = map.get(x);
        int[] ar2 = map.get(y);
        if (ar1[0] == ar2[0] && ar2[1] != ar1[1]) {
            return true;
        }
        return false;
    }


}
