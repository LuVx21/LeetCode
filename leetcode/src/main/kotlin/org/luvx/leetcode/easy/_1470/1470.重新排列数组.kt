package org.luvx.leetcode.easy._1470
/*
 * @lc app=leetcode.cn id=1470 lang=kotlin
 *
 * [1470] 重新排列数组
 */

// @lc code=start
class Solution {
    /**
     *给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     *
     * x1,x2,x3,x4,x5,y1,y2,y3,y4,y5
     *
     *
     * x1,y1,x2,y2,x3,y3,x4,y4,x5,y5
     */
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val array = IntArray(nums.size)
        for (i in array.indices) {
            array[i] = if (i % 2 == 0) nums[i / 2] else nums[n + i / 2]
        }
        return array
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    println(
        Solution().shuffle(array, 4).contentToString()
    )
}