package org.luvx.leetcode.kotlin.hard._84

/*
 * @lc app=leetcode.cn id=84 lang=kotlin
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
import java.util.*

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var max = 0
        val stack = Stack<Int>()
        for (i in heights.indices) {
            while (stack.isNotEmpty() && heights[stack.peek()] > heights[i]) {
                val area = stack.removeTopAndComputeArea(heights, i)
                max = maxOf(max, area)
            }
            stack.push(i)
        }
        while (stack.isNotEmpty()) {
            val area = stack.removeTopAndComputeArea(heights, heights.size)
            max = maxOf(max, area)
        }
        return max
    }

    private fun Stack<Int>.removeTopAndComputeArea(heights: IntArray, end: Int): Int {
        val min = pop()
        val start = if (isEmpty()) 0 else peek() + 1
        return heights[min] * (end - start)
    }
}
// @lc code=end

