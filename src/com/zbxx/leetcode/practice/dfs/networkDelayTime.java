package com.zbxx.leetcode.practice.dfs;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class networkDelayTime {


    /**
     * 建图  然后bfs  并且刷新每个节点到达的最小延迟时间  最后如果到达的节点数== n-1 那么说明可以到达所有  取其中最大延迟
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, LinkedList<int[]>> map = new HashMap<>();
        Map<Integer, Integer> ansMap = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            LinkedList<int[]> list = map.getOrDefault(times[i][0], new LinkedList<>());
            list.add(times[i]);
            map.put(times[i][0], list);
        }
        LinkedList<int[]> concats = map.get(k);
        if (concats == null || concats.size() == 0) {
            if (n == 1) {
                return 0;
            } else {
                return -1;
            }
        }
        dfs(concats, 0, map, ansMap, k);
        int max = -1;
        if (ansMap.size() == n - 1) {
            for (Integer value : ansMap.values()) {
                max = Math.max(max, value);
            }
        }
        return max;
    }

    private void dfs(LinkedList<int[]> concats, int pre, Map<Integer, LinkedList<int[]>> map, Map<Integer, Integer> ansMap, int k) {
        if (concats == null || concats.size() == 0) {
            return;
        }
        for (int[] concat : concats) {
            if (concat[1] == k) {
                continue;
            }
            Integer old = ansMap.get(concat[1]);
            if (old == null || pre + concat[2] < old) {
                //还没有到这条路径的或者当前路径更短
                ansMap.put(concat[1], pre + concat[2]);
                LinkedList<int[]> c = map.get(concat[1]);
                dfs(c, pre + concat[2], map, ansMap, k);
            }
        }
    }


}
