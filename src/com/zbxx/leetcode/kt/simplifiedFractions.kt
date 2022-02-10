package com.zbxx.leetcode.kt


fun main(args:Array<String>) {
    println(simplifiedFractions(7))
}


/**
 * 1447最简分数
 */
fun simplifiedFractions(n: Int): List<String> {
    val list = mutableListOf<String>()
    for (i in 1 until n)
        for (j in i+1 .. n){
            if(i==1){
                list.add("$i/$j")
                continue
            }
            if(i%2==0&&j%2==0){
                continue
            }
            val gcd =  gcd(i,j)
            if(gcd==1){
                list.add("$i/$j")
                continue
            }
        }
    return list
}

fun gcd(a:Int,b:Int): Int {
    return if(b == 0) a else gcd(b, a % b)
}