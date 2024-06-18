package org.luvx.leetcode.kotlin.easy._1491
/*
 * @lc app=leetcode.cn id=1491 lang=kotlin
 *
 * [1491] 去掉最低工资和最高工资后的工资平均值
 */

// @lc code=start
class Solution {
    /**
     * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
     * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
     * [4000,3000,1000,2000]
     * 解释：最低工资和最高工资分别是 1000 和 4000 。
     * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
     */
    fun average(salary: IntArray): Double {
        var max = 0
        var min: Int = Int.MAX_VALUE
        var result = 0.0
        for (num in salary) {
            if (num < min) {
                min = num
            }
            if (num > max) {
                max = num
            }
            result += num
        }
        return (result - max - min) / (salary.size - 2)
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(8000,9000,2000,3000,6000,1000)
    println(
        Solution().average(array)
    )
}