package org.luvx.leetcode.medium._1262
// @lc code=start

/*
 * @lc app=leetcode.cn id=1262 lang=kotlin
 *
 * [1262] 可被三整除的最大和
 */
class Solution {
    fun maxSumDivThree(nums: IntArray): Int {
        val N = 3
        var dp = intArrayOf(0, Int.MIN_VALUE, Int.MIN_VALUE)
        for (num in nums) {
            val dp2 = IntArray(N)
            for (i in 0 until N) {
                val index = (i + num) % N
                dp2[index] = maxOf(dp[index], dp[i] + num)
            }
            dp = dp2
        }
        return dp[0]
    }
}
// @lc code=end

