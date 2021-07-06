package com.zbxx.leetcode.practice.array;


import java.util.*;

/**
 * leetcode 1418 点菜展示表
 */
public class displayTable {

    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> names = new TreeSet<>();
        TreeMap<Integer, Map<String, String>> users = new TreeMap<>();
        for (List<String> order : orders) {
            names.add(order.get(2));
            Map<String, String> orderMap = users.getOrDefault(Integer.parseInt(order.get(1)), new HashMap<>());
            String num = orderMap.getOrDefault(order.get(2), "0");
            orderMap.put(order.get(2), (Integer.parseInt(num) + 1) + "");
            users.put(Integer.parseInt(order.get(1)), orderMap);
        }
        List<List<String>> result = new ArrayList<>();
        List<String> title = new ArrayList<>();
        title.addAll(names);
        title.add(0, "Table");
        result.add(title);
        Set<Integer> userKey = users.keySet();
        for (Integer integer : userKey) {
            List<String> uo = new ArrayList<>();
            uo.add("" + integer);
            for (String name : names) {
                uo.add(users.get(integer).getOrDefault(name, "0"));
            }
            result.add(uo);
        }
        return result;
    }


    public static void main(String[] args) {
        List<List<String>> data = new ArrayList<>();
        List<String> o1 = new ArrayList<>();
        o1.add("David");
        o1.add("3");
        o1.add("Ceviche");
        List<String> o2 = new ArrayList<>();
        o2.add("Corina");
        o2.add("10");
        o2.add("Beef Burrito");
        List<String> o3 = new ArrayList<>();
        o3.add("David");
        o3.add("3");
        o3.add("Fried Chicken");
        data.add(o1);
        data.add(o2);
        data.add(o3);
        displayTable displayTable = new displayTable();
        displayTable.displayTable(data);
    }


}
