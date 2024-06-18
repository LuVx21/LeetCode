package org.luvx.leetcode.kotlin.medium._56

import org.luvx.coding.common.enhancer.out

/*
 * @lc app=leetcode.cn id=56 lang=kotlin
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    /**
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * [[1,3],[2,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]]
     * [[1,4],[4,5]] -> [[1,5]]
     */
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val len = intervals.size
        if (len <= 1) {
            return intervals
        }
        intervals.sortWith { a, b -> a[0] - b[0] }
        if (len == 2) {
            return if (intervals[0][1] < intervals[1][0])
                intervals
            else
                arrayOf(
                    intArrayOf(
                        minOf(intervals[0][0], intervals[1][0]), maxOf(intervals[0][1], intervals[1][1])
                    )
                )
        }
        val result = arrayListOf<IntArray>()
        var prev = intervals[0]
        for (i in 1 until len) {
            val current = intervals[i]
            if (prev[1] < current[0]) {
                result.add(prev)
                prev = current
            } else {
                prev[0] = minOf(prev[0], current[0])
                prev[1] = maxOf(prev[1], current[1])
            }
        }
        result.add(prev)
        return result.toTypedArray()
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    val array = arrayOf(
//        intArrayOf(8, 10),
//        intArrayOf(1, 3),
//        intArrayOf(2, 6),
//        intArrayOf(15, 18)
        intArrayOf(1, 4),
//        intArrayOf(1, 4)
        intArrayOf(2, 3),
        intArrayOf(4, 5)
    )
    exec.merge(array).contentDeepToString().out()
}
