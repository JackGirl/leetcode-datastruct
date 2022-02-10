package com.zbxx.leetcode.kt

fun main(args:Array<String>) {
    println(isPalindrome("a"))
}

fun isPalindrome(s: String): Boolean {
    s.toCharArray().filter{ it.isLetterOrDigit() }.run {
        var l = 0
        var r = this.size-1
        while (l<r){
            if(this[l].toLowerCase() != this[r].toLowerCase()){
                return false
            }
            l++
            r--
        }
        return true
    }
}