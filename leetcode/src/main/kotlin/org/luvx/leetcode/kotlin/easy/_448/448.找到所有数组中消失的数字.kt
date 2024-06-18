package org.luvx.leetcode.kotlin.easy._448
/*
 * @lc app=leetcode.cn id=448 lang=kotlin
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
import kotlin.math.abs

class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for (num in nums) {
            val i = abs(num) - 1
            if (nums[i] > 0) {
                nums[i] *= -1
            }
        }
        val result = mutableListOf<Int>()
        for (i in nums.indices) {
            if (nums[i] > 0) {
                result.add(i + 1)
            }
        }
        return result
    }

    fun findDisappearedNumbers1(nums: IntArray): List<Int> {
        val size: Int = nums.size
        val result = mutableListOf<Int>()
        for (num in nums) {
            nums[(num - 1) % size] += size
        }

        for (i in nums.indices) {
            if (nums[i] <= size) {
                result.add(i + 1)
            }
        }
        return result
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    println(
        Solution().findDisappearedNumbers(array)
    )
}