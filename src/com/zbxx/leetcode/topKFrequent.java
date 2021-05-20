package com.zbxx.leetcode;


import java.util.*;

/**
 * 前K个高频单词
 */
public class topKFrequent {


    public static void main(String[] args) {
        String[] arr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(Arrays.toString(topKFrequent(arr, 4).toArray()));
    }


    public static List<String> topKFrequent(String[] words, int k) {
        //记录起始index
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int[] t = map.get(words[i]);
            if (t == null) {
                int[] s = new int[2];
                s[0] = i;
                s[1]++;
                map.put(words[i], s);
            } else {
                t[1]++;
            }
        }
        List<String> s = new ArrayList<>();
        List<Map.Entry<String, int[]>> d = new ArrayList<>(map.entrySet());
        Collections.sort(d, new Comparator<Map.Entry<String, int[]>>() {
            @Override
            public int compare(Map.Entry<String, int[]> o1, Map.Entry<String, int[]> o2) {
                int[] a1 = o1.getValue();
                int[] a2 = o2.getValue();
                if (a1[1] > a2[1]) {
                    return -1;
                }
                if (a1[1] == a2[1]) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < k; i++) {
            s.add(d.get(i).getKey());
        }
        return s;
    }


}
