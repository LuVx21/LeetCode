package org.luvx.leetcode.medium._128

import org.luvx.coding.common.enhancer.out

/*
 * @lc app=leetcode.cn id=128 lang=kotlin
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * 要求算法的时间复杂度为 O(n)。
     * 100, 4, 200, 1, 3, 2 -> 4
     * 排序后最长连续的长度
     */
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val set = nums.toHashSet()
        var max = 1
        for (num in nums) {
            if (set.remove(num)) {
                var temp = num
                var len = 1
                while (set.remove(temp - 1)) {
                    temp--
                }
                len += (num - temp)
                temp = num
                while (set.remove(temp + 1)) {
                    temp++
                }
                len += (temp - num)
                max = maxOf(max, len)
            }
        }
        return max
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    val array =
//        intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)
        intArrayOf(100, 4, 200, 1, 3, 2)
    exec.longestConsecutive(array).out()
}