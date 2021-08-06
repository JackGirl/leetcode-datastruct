package com.zbxx.leetcode.practice.bfs;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 847 访问所有节点的最短路径
 * 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
 * <p>
 * 给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
 * <p>
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class shortestPathLength {


    /**
     * 前面想到用set判断当前节点时访问的节点有哪些判断  但是不好比较 而且内存大
     * 看了下官方题解思路  使用 bitmap解决
     *
     * @param graph
     * @return
     */
    public int shortestPathLength(int[][] graph) {
        int min = Integer.MAX_VALUE;
        int bit = (int) (Math.pow(2, graph.length) - 1);
        boolean[][] seen = new boolean[graph.length][bit + 1];
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            seen[i][1 << i] = true;
            deque.offer(new int[]{i, 1 << i, 0});
        }
        //bfs
        while (!deque.isEmpty()) {
            int[] node = deque.poll();
            int no = node[0], accessNode = node[1], step = node[2];
            if (accessNode == ((1 << graph.length) - 1)) {
                return step;
            }
            for (int N : graph[no]) {
                int maskV = accessNode | (1 << N);
                if (!seen[N][maskV]) {
                    deque.offer(new int[]{N, maskV, step + 1});
                }
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[][] points = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(new shortestPathLength().shortestPathLength(points));
    }


}
