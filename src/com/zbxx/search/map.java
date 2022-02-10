package com.zbxx.search;


import java.util.Arrays;

/**
 * 图
 */
public class map {


    /**
     * dijkstra 单源最短路径
     * 选定一个出发点作为当前最短路径点 （贪心？） 每次选出距离最短的  再重复选择 并且更新最短距离
     */

    public static int dijkstra(int points[][][],int start,int end){
        int set = 0;
        for (int i = 1; i <=points.length ; i++) {
            set|=1<<(i-1);
        }
        int [] dist = new int[points.length+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        set^=1<<(start-1);
        find(start,points,set,dist);
        return dist[end];
    }



    static private void find(int minNode, int[][][] points, int set, int[] dist) {
        int min = Integer.MAX_VALUE;
        int nextMin = Integer.MAX_VALUE;
        for (int[] side : points[minNode - 1]) {
            dist[side[0]] = Math.min(dist[side[0]],side[1]+dist[minNode]);
            if(dist[side[0]]<min){
                nextMin = side[0];
                min = dist[side[0]];
            }
        }
        set^=1<<(nextMin-1);
        if(set==0){
            return;
        }
        if(nextMin!=Integer.MAX_VALUE){
            find(nextMin,points,set ,dist);
        }
    }

    /**
     *  动态 规划 中间节点思想
     *  可以求出多源最短路径
     *  可以包含负权边
     */
    public static int floyd(int[][][] points,int start,int end){
       int [][] dist = new int[points.length][points.length];
       int [][] path = new int[points.length][points.length];
        for (int i = 0; i < path.length; i++) {
            for (int i1 = 0; i1 < path[i].length; i1++) {
                dist[i][i1] = 10000;
                path[i][i1] = -1;
            }
            dist[i][i] = 0;
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                int relation = points[i][j][0];
                int line = points[i][j][1];
                dist[i][relation] = line;
            }
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length ; k++) {
                    if(j==i||k==i){
                        continue;
                    }
                    if(dist[j][k]>dist[j][i]+dist[i][k]){
                        dist[j][k] = dist[j][i]+dist[i][k];
                        path[j][k] = i;
                    }
                }
            }
        }
        return queryPath(start,end,path,dist);
    }


    static int queryPath(int u,int v,int path[][],int dist[][]){
        if(path[u][v]==-1){
            System.out.println("从"+u+"到"+v+" "+dist[u][v]);
            return dist[u][v];
        }
        int mid = path[u][v];
        int l = queryPath(u,mid,path,dist);
        int r = queryPath(mid,v,path,dist);
        return l+r;
    }

    public static void main(String[] args) {
     /*   int [][][] points = {
                {{2, 1}, {3, 12}},
                {{4, 3}, {3, 9}},
                {{5, 5}},
                {{3,4},{5,13},{6,15}},
                {{6,4}},
                {}
        };
        System.out.println(dijkstra(points,3,6));
*/
        int [][][] ps = {
                {{1,5},{3,7}},
                {{2,4},{3,2}},
                {{1,3},{3,2},{0,3}},
                {{2,1}}
        };
        System.out.println(floyd(ps,1,0));
    }
}
