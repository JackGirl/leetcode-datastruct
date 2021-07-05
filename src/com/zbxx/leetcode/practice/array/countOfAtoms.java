package com.zbxx.leetcode.practice.array;


import java.util.*;

/**
 * leetcode  726  原子数量
 */
public class countOfAtoms {


    /**
     * @param formula
     * @return
     */
    public String countOfAtoms(String formula) {
        char[] sr = formula.toCharArray();
        Deque<Map<String, Integer>> stack = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sr.length; ) {
            if (sr[i] == '(') {
                stack.push(map);
                map = new HashMap<>();
                i++;
            } else if (Character.isUpperCase(sr[i])) {
                builder.setLength(0);
                builder.append(sr[i]);
                int next = i + 1;
                int num = 0;
                while (next < sr.length && !Character.isUpperCase(sr[next]) && sr[next] != ')' && sr[next] != '(') {
                    if (Character.isDigit(sr[next])) {
                        while (next < sr.length && Character.isDigit(sr[next])) {
                            num = num * 10 + (sr[next] - '0');
                            next++;
                        }
                    } else {
                        builder.append(sr[next]);
                        next++;
                    }
                }
                String key = builder.toString();
                if (num == 0) {
                    num = 1;
                }
                map.put(key, map.getOrDefault(key, 0) + num);
                i = next;
            } else {
                //右括号  stack弹出 把当前一层的乘以括号外数字 放入stack弹出的map
                int next = i + 1;
                int num = 0;
                while (next < sr.length && Character.isDigit(sr[next])) {
                    num = num * 10 + (sr[next] - '0');
                    next++;
                }
                i = next;
                if (num == 0) {
                    num = 1;
                }
                Map<String, Integer> m = stack.pop();
                Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
                for (Map.Entry<String, Integer> stringIntegerEntry : entrySet) {
                    m.put(stringIntegerEntry.getKey(), m.getOrDefault(stringIntegerEntry.getKey(), 0) + stringIntegerEntry.getValue() * num);
                }
                map = m;
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        String[] arr = new String[entrySet.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : entrySet) {
            if (stringIntegerEntry.getValue() > 1) {
                arr[idx++] = stringIntegerEntry.getKey() + stringIntegerEntry.getValue();
            } else {
                arr[idx++] = stringIntegerEntry.getKey();
            }
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        countOfAtoms countOfAtoms = new countOfAtoms();
        System.out.println(countOfAtoms.countOfAtoms("K4(ON(SO3)2)2"));
    }


}
