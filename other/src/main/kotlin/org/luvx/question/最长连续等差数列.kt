package org.luvx.question

import org.luvx.coding.common.enhancer.out

/**leetcode-1027 扩展
 * 给定一个整数数组 A，返回 A 中最长连续等差子序列的长度
 */
fun longestArithSeqLength(nums: IntArray): Int {
    var value = nums[1] - nums[0]
    var cnt = 1
    var temp = cnt
    for (i in 2 until nums.size) {
        val v = nums[i] - nums[i - 1]
        if (v == value) {
            temp++
        } else {
            temp = 1
            value = v
        }
        cnt = cnt.coerceAtLeast(temp)
    }
    return cnt + 1
}

fun main() {
    listOf(
        intArrayOf(0, 5, 14, 19, 24, 29),
        intArrayOf(1, 2, 4, 7),
        intArrayOf(3, 6, 7, 8),
        intArrayOf(3, 6, 9, 12)
    )
        .forEach { array -> longestArithSeqLength(array).out() }
}
