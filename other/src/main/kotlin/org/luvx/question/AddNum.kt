package org.luvx.question

import org.luvx.leetcode.out

fun addNum(num1: Int, num2: Int): Int {
    var num1 = num1
    var num2 = num2
    while (num2 != 0) {
        val temp = num1 xor num2
        num2 = num1 and num2 shl 1
        num1 = temp
    }
    return num1
}

fun main() {
    addNum(10, 12).out()
    addNum(15, 27).out()
}