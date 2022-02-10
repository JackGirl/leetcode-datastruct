package com.zbxx.search;


import java.util.Arrays;

/**
 * 图
 */
public class map {


    /**
     * dijkstra 单源最短路径
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


    public static void main(String[] args) {
        int [][][] points = {
                {{2, 1}, {3, 12}},
                {{4, 3}, {3, 9}},
                {{5, 5}},
                {{3,4},{5,13},{6,15}},
                {{6,4}},
                {}
        };
        System.out.println(dijkstra(points,3,6));
    }
}
