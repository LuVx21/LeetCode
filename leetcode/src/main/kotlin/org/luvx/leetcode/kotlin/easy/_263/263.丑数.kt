package org.luvx.leetcode.kotlin.easy._263

import org.luvx.coding.common.enhancer.out

// @lc code=start
/*
 * @lc app=leetcode.cn id=263 lang=kotlin
 *
 * [263] 丑数
 */
class Solution {
    /**
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     * 14 = 2*7 false
     * 30 = 2*3*5 true
     * <=0 false
     */
    fun isUgly(n: Int): Boolean {
        if (n <= 1) {
            return n == 1
        }
        var temp = n
        val intArrayOf = intArrayOf(2, 3, 5)
        for (i in intArrayOf) {
            while (temp % i == 0) {
                temp /= i
            }
        }
        return temp == 1
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    intArrayOf(0, 1, 14, 30)
        .forEach { n -> exec.isUgly(n).out() }
}