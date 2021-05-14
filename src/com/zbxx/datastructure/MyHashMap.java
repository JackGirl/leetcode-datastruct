package com.zbxx.datastructure;

/**
 * @author: soft
 * <description>
 * practice map
 * </description>
 * @date: 2020/1/6
 */
public class MyHashMap<K, V> {


    Object[] data;

    private final static int MIN_SIZE = 16;

    public MyHashMap() {
        data = new Object[MIN_SIZE];
    }

    public MyHashMap(int size) {
        if (size < MIN_SIZE) {
            data = new Object[MIN_SIZE];
        } else {
            data = new Object[size];
        }
    }

    public void put(K k, V v) {

        int h;
        System.out.println((k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16));
    }


    public static void main(String[] args) {
        MyHashMap<String, Object> myHashMap = new MyHashMap<>();
        myHashMap.put("我", "1");
    }


}
