package com.zbxx.leetcode.kt

fun main(args :Array<String>) {
    println(countKDifference(intArrayOf(1,3),2))
}

/**
 * 2006 绝对差值为K的数对 数量
 */
fun countKDifference(nums: IntArray, k: Int): Int {
    var map = hashMapOf<Int,Int?>()
    var result:Int = 0
    nums.forEach {
        var d1 = map[it-k]
        result= if(d1!=null){
            result+d1
        }else{
            result
        }
        var d2 = map[it+k]
        result= if(d2!=null){
            result+d2
        }else{
            result
        }
        map[it] = if(map[it]==null){
            1
        }else{
            map[it]?.plus(1)
        }
    }
    return result
}

