package org.luvx.leetcode.kotlin.easy._1486
/*
 * @lc app=leetcode.cn id=1486 lang=kotlin
 *
 * [1486] 数组异或操作
 */

// @lc code=start
class Solution {
    /**
     * 给你两个整数，n 和 start 。
     * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
     * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
     * n = 5 start = 0
     * 8
     */
    fun xorOperation(n: Int, start: Int): Int {
        var result = start
        for (i in 1 until n) {
            result = result xor (start + 2 * i)
        }
        return result
    }
}
// @lc code=end

fun main() {
    println(
        Solution().xorOperation(5, 0)
    )
}