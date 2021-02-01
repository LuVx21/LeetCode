package org.luvx.leetcode.easy._1512
/*
 * @lc app=leetcode.cn id=1512 lang=kotlin
 *
 * [1512] 好数对的数目
 */

// @lc code=start
class Solution {
    /**
     * 给你一个整数数组 nums 。
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对。
     * 返回好数对的数目。
     * 0 1 2 3 4 5
     * 1 2 3 1 1 3
     * (0,3), (0,4), (3,4), (2,5)
     */
    fun numIdenticalPairs(nums: IntArray): Int {
        val array = IntArray(101)
        var result = 0
        for (i in nums) {
            val cnt = array[i]
            array[i] = cnt + 1
            result += cnt
        }
        return result
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(1, 2, 3)
    println(array.contentToString())
    println(Solution().numIdenticalPairs(array))
}
