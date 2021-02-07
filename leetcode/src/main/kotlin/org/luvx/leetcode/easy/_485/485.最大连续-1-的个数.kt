package org.luvx.leetcode.easy._485

import org.luvx.leetcode.out

/*
 * @lc app=leetcode.cn id=485 lang=kotlin
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
    /**
     * 给定一个二进制数组，计算其中最大连续1的个数。
     */
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var cnt = 0
        for (num in nums) {
            if (num == 1) {
                cnt++
            } else {
                max = max.coerceAtLeast(cnt)
                cnt = 0
            }
        }
        return max.coerceAtLeast(cnt)
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(1, 1, 0, 1, 1, 1)
    Solution().findMaxConsecutiveOnes(array).out()
}
