package com.zbxx.leetcode.kt



fun main(args: Array<String>) {
    println(increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))
}

fun increasingTriplet(nums: IntArray): Boolean {
   var m1  =Integer.MAX_VALUE
    var m2 = Int.MAX_VALUE
    for(i in nums.indices){
        if(nums[i]<m1){
            m1 = nums[i]
            continue
        }
        if(nums[i]>m1&&nums[i]<m2){
            m2 = nums[i]
            continue
        }
        if(nums[i]>m1&&nums[i]>m2){
            return true
        }
    }
    return false;
}
