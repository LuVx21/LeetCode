package org.luvx.leetcode.easy._1480
/*
 * @lc app=leetcode.cn id=1480 lang=kotlin
 *
 * [1480] 一维数组的动态和
 */

// @lc code=start
class Solution {
    /**
     * 给你一个数组 nums 。
     * 数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和。
     * 1,2,3,4
     * 1, 1+2, 1+2+3, 1+2+3+4 -> 1,3,6,10
     */
    fun runningSum(nums: IntArray): IntArray {
        val array = IntArray(nums.size)
        for (i in array.indices) {
            array[i] = nums[i] + if (i > 0) array[i - 1] else 0
        }
        return array
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(3, 1, 2, 10, 1)
    println(
        Solution().runningSum(array).contentToString()
    )
}