package com.zbxx.leetcode;


import java.util.*;

/**
 * 前K个高频单词
 */
public class topKFrequent {


    public static void main(String[] args) {
        String[] arr = {"aaa", "a"};
        System.out.println(Arrays.toString(topKFrequent(arr, 1).toArray()));
    }


    public static List<String> topKFrequent(String[] words, int k) {
        //记录起始index
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.merge(words[i], 1, Integer::sum);
        }
        List<String> s = new ArrayList<>();
        List<Map.Entry<String, Integer>> d = new ArrayList<>(map.entrySet());
        Collections.sort(d, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                Integer a1 = o1.getValue();
                Integer a2 = o2.getValue();
                if (a1 > a2) {
                    return -1;
                }
                if (a1.equals(a2)) {
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
