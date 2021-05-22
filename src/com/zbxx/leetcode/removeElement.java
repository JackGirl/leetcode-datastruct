package com.zbxx.leetcode;


/**
 * 原地删除固定元素数组
 */
public class removeElement {

    public static void main(String[] args) {
        int nums[] = {3, 2, 2, 4};
        int n = removeElement(nums, 2);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int size = 0;
        for (int i = 0; i < nums.length - size; ) {
            if (nums[i] == val) {
                int temp = nums[nums.length - 1 - size];
                nums[nums.length - 1 - size] = nums[i];
                nums[i] = temp;
                size++;
            } else {
                i++;
            }
        }
        return nums.length - size;
    }

    /**
     * 保证顺序版
     * @param nums
     * @param val
     * @return
     */
  /*  public static int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        int size = 0;
        int start = 0;
        for (int i = start; i < nums.length-size; ) {
           if(nums[i]==val){
               size++;
               start = i;
               for (int j = i+1; j < nums.length; j++) {
                   int temp = nums[j-1];
                   nums[j-1] = nums[j];
                   nums[j] = temp;
               }
           }else{
               i++;
           }
        }
        return nums.length-size;
    }
*/


}
