package com.zbxx.leetcode.practice.dfs;


import cn.hutool.core.util.StrUtil;

import java.util.*;

/**
 * 802.在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * <p>
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * <p>
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * <p>
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class eventualSafeNodes {


    /**
     * dfs没啥好说的
     *
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> globalDo = new TreeSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (!globalDo.contains(i)) {
                Set<Integer> visited = new HashSet<>();
                dfs(i, graph, visited, globalDo);
            }
        }
        ans.addAll(globalDo);
        return ans;
    }

    private boolean dfs(int i, int[][] graph, Set<Integer> visited, Set<Integer> globalDo) {
        if (visited.contains(i)) {
            return false;
        }
        visited.add(i);
        if (graph[i].length == 0) {
            globalDo.add(i);
            return true;
        }
        for (int i1 : graph[i]) {
            if (globalDo.contains(i1)) {
                continue;
            }
            boolean t = dfs(i1, graph, visited, globalDo);
            if (!t) {
                return false;
            }
            globalDo.add(i1);
        }
        globalDo.add(i);
        return true;
    }


    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(StrUtil.toString(new eventualSafeNodes().eventualSafeNodes(graph)));
    }

}
