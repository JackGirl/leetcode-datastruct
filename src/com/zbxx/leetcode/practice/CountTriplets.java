package com.zbxx.leetcode.practice;


/**
 * 给你一个整数数组 arr 。
 * <p>
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * <p>
 * a 和 b 定义如下：
 * <p>
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * <p>
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CountTriplets {


    public static void main(String[] args) {
        int[] arr = new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22};
        System.out.println(countTriplets(arr));
    }

    public static int countTriplets(int[] arr) {
        int sum = 0;
        int g = arr.length - 1;
        while (g > 0) {
            int k = g - 1;
            int xor = arr[g];
            while (k >= 0) {
                xor ^= arr[k];
                if (xor == 0) {
                    sum += g - k;
                }
                k--;
            }
            g--;
        }
        return sum;
    }


}
