package org.luvx.leetcode.easy._338

import org.luvx.leetcode.out

// @lc code=start
/*
 * @lc app=leetcode.cn id=338 lang=kotlin
 *
 * [338] 比特位计数
 */
class Solution {
    /**
     * 给你一个整数 n,对于 0 <= i <= n 中的每个 i,
     * 计算其二进制表示中 1 的个数,返回一个长度为 n + 1 的数组 ans 作为答案
     */
    fun countBits(num: Int): IntArray {
        val result = IntArray(num + 1)
        for (i in 1..num) {
            result[i] = result[i shr 1] + (i and 1)
        }
        return result
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    intArrayOf(2, 5)
        .map(exec::countBits)
        .map(IntArray::contentToString)
        .forEach { s -> s.out() }
}