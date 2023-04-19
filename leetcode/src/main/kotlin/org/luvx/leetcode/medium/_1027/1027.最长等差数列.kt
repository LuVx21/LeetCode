package org.luvx.leetcode.medium._1027

import org.luvx.coding.common.enhancer.out

/*
 * @lc app=leetcode.cn id=1027 lang=kotlin
 *
 * [1027] 最长等差数列
 */

// @lc code=start
class Solution {
    /**
     * 给定一个整数数组 A，返回 A 中最长等差子序列的长度
     * 3,6,9,12 -> 4
     * 3,3,6,9,12 -> 4
     * 9,4,7,2,10 -> 4,7,10 -> 3
     * 20,1,15,3,10,5,8 -> 20,15,10,5 -> 4
     */
    fun longestArithSeqLength(nums: IntArray): Int {
        var cnt = 2
        val mapArray = Array(nums.size) { HashMap<Int, Int>() }
        for (i in nums.indices) {
            val map = mapArray[i]
            for (j in 0 until i) {
                val d = nums[i] - nums[j]
                val value = mapArray[j].getOrDefault(d, 1) + 1
                map[d] = value
                cnt = cnt.coerceAtLeast(value)
            }
        }
        return cnt
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    exec.longestArithSeqLength(intArrayOf(9, 4, 7, 2, 10)).out()
}