package com.zbxx

fun main(args :Array<String>) {
    println(countKDifference(intArrayOf(1,3),2))
}

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