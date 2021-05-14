package com.zbxx.leetcode;


/**
 * 两个有序数组中位数
 */
public class FindMedianSortedArrays {
    //1 3 3 4  6 7 9 11
    public static void main(String[] args) {
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        System.out.println(middle(nums1, nums2));

    }

    public static double middle(int[] nums1, int[] nums2) {
        int middleIndex = (nums1.length + nums2.length) / 2;
        int overFlow = (nums1.length + nums2.length) % 2;
        int first = 0, other = 0;
        int[] arr = new int[middleIndex + 1];
        int start = 0;
        while (start < arr.length && first < nums1.length && other < nums2.length) {
            if (nums1[first] <= nums2[other]) {
                arr[start] = nums1[first];
                start++;
                first++;
                continue;
            }
            if (nums2[other] <= nums1[first]) {
                arr[start] = nums2[other];
                start++;
                other++;
            }
        }

        while (start < arr.length) {
            if (other == nums2.length) {
                arr[start] = nums1[first];
                first++;
                start++;
                continue;
            }
            if (first == nums1.length) {
                arr[start] = nums2[other];
                other++;
                start++;
            }
        }

        double result = arr[arr.length - 1];
        return overFlow == 1 ? result : (result + arr[arr.length - 2]) / 2;
    }


}
