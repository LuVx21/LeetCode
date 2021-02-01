package org.luvx.leetcode.easy._1502

/*
 * @lc app=leetcode.cn id=1502 lang=kotlin
 *
 * [1502] 判断能否形成等差数列
 */

// @lc code=start
class Solution {
    /**
     * 给你一个数字数组 arr 。
     * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
     * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
     */
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        arr.sort()
        val diff = arr[1] - arr[0]
        for (i in 2 until arr.size) {
            if (diff != (arr[i] - arr[i - 1])) {
                return false
            }
        }
        return true
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(1, 7)
    println(
        Solution().canMakeArithmeticProgression(array)
    )
}