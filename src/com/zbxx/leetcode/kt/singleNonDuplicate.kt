package com.zbxx.leetcode.kt


/**
 * 540 有序数组的单一元素
 */
fun singleNonDuplicate(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }
    var l = 0
    var r = nums.size - 1
    var mid = 0;
    while (l+1< r) {
        mid = l + (r - l) / 2
        if (nums[mid] != nums[mid-1]&&nums[mid]!=nums[mid+1]) {
         return nums[mid]
        }
        if(nums[mid]==nums[mid-1]){
            if((mid-1)%2==0){
                l = mid
            }else{
                r = mid
            }
        }else{
            if(mid%2==0){
                l = mid
            }else{
                r = mid
            }
        }
    }
        if((r-1)%2==0){
            return nums[l]
        }else{
            return nums[r]
        }
}


fun main(args: Array<String>) {
    val nums = intArrayOf(9,9,10)
    println(singleNonDuplicate(nums))
}