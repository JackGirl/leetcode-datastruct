package com.zbxx.leetcode.book.hash;


import com.zbxx.leetcode.struct.TreeNode;

import java.util.*;

/**
 * leetcode book hash 寻找重复的子树
 */
public class hash_findDuplicateSubtrees {


    /**
     * 之前做二叉树有一个序列化的  现在也可以拿来用
     * bfs进行访问序列化字符串 然后进行Set查询字符是否已存在
     *
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        Set<String> chars = new HashSet<>();
        Set<String> set = new HashSet<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            String str = serialize(node);
            if (chars.contains(str) && !set.contains(str)) {
                result.add(node);
                set.add(str);
            }
            chars.add(str);
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
        return result;
    }

    private String serialize(TreeNode node) {
        if (node == null) {
            return "#,";
        }
        String str = node.val + ",";
        return str + serialize(node.left) + serialize(node.right);
    }

}
