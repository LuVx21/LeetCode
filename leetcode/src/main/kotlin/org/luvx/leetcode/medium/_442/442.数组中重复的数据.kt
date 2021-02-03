package org.luvx.leetcode.medium._442
/*
 * @lc app=leetcode.cn id=442 lang=kotlin
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
import kotlin.math.abs

class Solution {
    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     * 找到所有出现两次的元素。
     * 4,3,2,7,8,2,3,1
     * 2,3
     */
    fun findDuplicates(nums: IntArray): List<Int> {
        val list: MutableList<Int> = mutableListOf()
        for (num in nums) {
            val index = abs(num) - 1
            val tmp = nums[index]
            if (tmp < 0) {
                list.add(index + 1)
            } else {
                nums[index] = -tmp
            }
        }
        return list
    }

    fun findDuplicates1(nums: IntArray): List<Int> {
        val size = nums.size
        for (i in nums.indices) {
            val abs = abs(nums[i])
            val index = (if (abs > size) abs - size else nums[i]) - 1
            val i1 = nums[index]
            nums[index] = if (i1 <= size) i1 + size else -1 * i1
        }

        val list = mutableListOf<Int>()
        for (i in nums.indices) {
            val num = nums[i]
            if (num < 0 && num + size < 0) {
                list.add(i + 1)
            }
        }
        return list
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(4, 3, 2, 7, 8, 2, 1, 1)
    println(
        Solution().findDuplicates(array)
    )
}