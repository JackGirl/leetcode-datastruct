package com.zbxx.leetcode.book.binarysearch;


import com.zbxx.leetcode.struct.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode book binaryTree  序列化 反序列化
 */
public class binaryTree_Codec {


    public static String serialize(TreeNode root) {
        if (root == null) {
            return "@,";
        }
        String str = root.val + ",";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    public static TreeNode deserialize(String data) {
        String[] sr = data.split(",");
        Deque<String> deque = new LinkedList<>(Arrays.asList(sr));
        TreeNode root = build(deque);
        return root;
    }


    public static TreeNode build(Deque<String> deque) {
        if (deque.isEmpty()) {
            return null;
        }
        String s = deque.poll();
        if (s.equals("@")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = build(deque);
        node.right = build(deque);
        return node;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        String s = serialize(root);
        System.out.println(s);
        TreeNode n = deserialize(s);
        System.out.println(n);
    }


}
