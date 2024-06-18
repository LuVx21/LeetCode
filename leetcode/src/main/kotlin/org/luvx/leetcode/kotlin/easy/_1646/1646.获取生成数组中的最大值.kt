package org.luvx.leetcode.kotlin.easy._1646

import org.luvx.coding.common.enhancer.out

/*
 * @lc app=leetcode.cn id=1646 lang=kotlin
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
class Solution {
    /**
     * nums[0] = 0
     * nums[1] = 1
     * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
     * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
     */
    fun getMaximumGenerated(n: Int): Int {
        if (n == 0 || n == 1) {
            return n
        }
        val array = IntArray(n + 1)
        array[0] = 0
        array[1] = 1
        var max = array[1]

        for (i in 2..n) {
            if (i % 2 == 0) {
                array[i] = array[i / 2]
            } else {
                val k = (i - 1) / 2
                array[i] = array[k] + array[k + 1]
            }
            max = maxOf(max, array[i])
        }

        // 2
        // var i = 1
        // while (2 * i + 1 <= n) {
        //     array[2 * i] = array[i]
        //     array[2 * i + 1] = array[i] + array[i + 1]
        //     max = maxOf(max, array[2 * i + 1])
        //     i++
        // }
        // 1

        return max
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    exec.getMaximumGenerated(7).out()
    exec.getMaximumGenerated(2).out()
    exec.getMaximumGenerated(3).out()
}