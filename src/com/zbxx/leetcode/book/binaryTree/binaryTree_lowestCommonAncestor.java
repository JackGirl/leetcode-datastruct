package com.zbxx.leetcode.book.binaryTree;


import com.zbxx.leetcode.struct.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * leetcode book  二叉树  两节点的最近公共祖先
 */
public class binaryTree_lowestCommonAncestor {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode lr = new TreeNode(4);

        root.left = l;
        root.right = r;
        l.right = lr;

        System.out.println(lowestCommonAncestor(root, r, lr));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> n1 = new LinkedList<>();
        LinkedList<TreeNode> n2 = new LinkedList<>();
        dfs(root, p, n1);
        dfs(root, q, n2);
        Iterator<TreeNode> l = n1.iterator();
        Iterator<TreeNode> r = n2.iterator();
        TreeNode pre = null;
        while (r.hasNext() && l.hasNext()) {
            TreeNode ln = l.next();
            TreeNode lr = r.next();
            if (ln == lr) {
                pre = ln;
            }
            if (ln == p || ln == q) {
                break;
            }
        }
        return pre;
    }

    private static boolean dfs(TreeNode root, TreeNode q, LinkedList<TreeNode> list) {
        if (root == null) {
            return false;
        }
        list.add(root);
        if (root == q) {
            return true;
        }
        if (root.left == null || root.right == null) {
            if (root.left != null) {
                boolean r = dfs(root.left, q, list);
                if (!r) {
                    list.pollLast();
                }
                return r;
            }
            if (root.right != null) {
                boolean r = dfs(root.right, q, list);
                if (!r) {
                    list.pollLast();
                }
                return r;
            }
        } else {
            boolean r = dfs(root.left, q, list);
            if (!r) {
                list.pollLast();
                boolean right = dfs(root.right, q, list);
                if (!right) {
                    list.pollLast();
                }
                return right;
            }
            return true;
        }
        return false;
    }

}
