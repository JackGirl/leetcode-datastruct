package com.zbxx.leetcode.book.hash;


import java.util.HashSet;
import java.util.Set;

/**
 * leetcode book hash 快乐数
 */
public class hash_isHappy {


    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int r = 0;
            while (n > 0) {
                int bit = n % 10;
                n /= 10;
                r += bit * bit;
            }
            n = r;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }


    public static void main(String[] args) {
        hash_isHappy hash_isHappy = new hash_isHappy();
        System.out.println(hash_isHappy.isHappy(2));
    }
}
