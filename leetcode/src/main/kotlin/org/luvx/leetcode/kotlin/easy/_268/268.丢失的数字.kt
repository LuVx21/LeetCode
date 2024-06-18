package org.luvx.leetcode.kotlin.easy._268
/*
 * @lc app=leetcode.cn id=268 lang=kotlin
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    /**
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     *
     * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
     * n+1个数字, 数组长为n, 存在一个没有出现在数组中的数字
     *
     * 9,6,4,2,3,5,7,0,1 -> 8
     */
    fun missingNumber(nums: IntArray): Int {
        var len: Int = nums.size
        for (i in 0 until len) {
            len = len xor i
            len = len xor nums[i]
        }
        return len
    }

    fun missingNumber1(nums: IntArray): Int {
        val len: Int = nums.size
        var sum = len * (len + 1) / 2
        for (i in 0 until len) {
            sum -= nums[i]
        }
        return sum
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(1, 2, 3)
    println(
            Solution().missingNumber(array)
    )
}