package com.zbxx.leetcode.kt

import java.util.*
import kotlin.math.min

fun main(args: Array<String>) {
    val arr = intArrayOf(9, 4, 1, 7)
    println(minimumDifference(arr,2))
}

/**
 * 1984 学生分数的最小差值
 */
fun minimumDifference(nums: IntArray, k: Int): Int {
    nums.sort()
    if(k==1){
        return 0
    }
    var rs = Int.MAX_VALUE
    val q:Deque<Int> = LinkedList()
    for (num in nums) {
        if(q.size==k){
            q.pollFirst()
        }
        q.addLast(num)
        if(q.size==k){
            rs = min(calculate(q),rs)
        }
    }
    return rs
}

fun calculate(q: Deque<Int>):Int{
    var max = q.peekFirst()
    var min = q.peekLast()
    return max-min
}