package com.zbxx.leetcode.practice.dfs;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode LCP 07
 */
public class numWays {

    int num = 0;

    public int numWays(int n, int[][] relation, int k) {
        List<Set<Integer>> map = new ArrayList<>(relation.length);
        for (int i = 0; i < n; i++) {
            map.add(new HashSet<>());
        }
        for (int i = 0; i < relation.length; i++) {
            for (int j = 0; j < relation[i].length; j++) {
                map.get(relation[i][0]).add(relation[i][1]);
            }
        }
        dfs(0, 0, k, n - 1, map);
        return num;
    }

    private void dfs(int idx, int nk, int k, int n, List<Set<Integer>> map) {
        if (nk > k || idx > map.size()) {
            return;
        }
        if (nk == k && idx == n) {
            num++;
            return;
        }
        Set<Integer> point = map.get(idx);
        for (Integer integer : point) {
            dfs(integer, nk + 1, k, n, map);
        }
    }

    public static void main(String[] args) {
        int[][] t = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        numWays numWays = new numWays();
        System.out.println(numWays.numWays(5, t, 3));
    }


}
