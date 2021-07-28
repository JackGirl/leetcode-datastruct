package com.zbxx.leetcode.practice.bfs;

import cn.hutool.core.util.StrUtil;
import com.zbxx.leetcode.struct.TreeNode;

import java.util.*;


/**
 * 每日一题 863 二叉树中所有距离为K的节点
 */
public class distanceK {


    /**
     * 建图  然后从target节点开始bfs查找
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Set<Integer> visited = new HashSet<>();
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        buildMap(map, root.val, root.left);
        buildMap(map, root.val, root.right);
        bfs(map, visited, result, k, target.val);
        return result;
    }

    private static void bfs(Map<Integer, LinkedList<Integer>> map, Set<Integer> visited, List<Integer> result, int k, int target) {
        int step = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(target);
        visited.add(target);
        while (!deque.isEmpty()) {
            if (step == k) {
                result.addAll(deque);
                return;
            }
            step++;
            int size = deque.size();
            visited.addAll(deque);
            for (int i = 0; i < size; i++) {
                Integer relation = deque.poll();
                LinkedList<Integer> c = map.get(relation);
                if (c != null) {
                    for (Integer integer : c) {
                        if (!visited.contains(integer)) {
                            deque.add(integer);
                        }
                    }
                }


            }

        }
    }

    private static void buildMap(Map<Integer, LinkedList<Integer>> map, int val, TreeNode node) {
        if (node == null) {
            return;
        }
        LinkedList<Integer> concat = map.getOrDefault(val, new LinkedList<>());
        concat.add(node.val);
        map.put(val, concat);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(val);
        map.put(node.val, linkedList);
        buildMap(map, node.val, node.left);
        buildMap(map, node.val, node.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);

        System.out.println(StrUtil.toString(distanceK(node, node, 0)));
    }

}
