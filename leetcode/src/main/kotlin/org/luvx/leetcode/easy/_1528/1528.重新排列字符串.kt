package org.luvx.leetcode.easy._1528
/*
 * @lc app=leetcode.cn id=1528 lang=kotlin
 *
 * [1528] 重新排列字符串
 */

// @lc code=start
class Solution {
    /**
     * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
     * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
     * 返回重新排列后的字符串。
     * s = "codeleet", indices = [4,5,6,7,0,2,1,3]
     * codeleet
     *
     * 输出："leetcode"
     */
    fun restoreString(s: String, indices: IntArray): String {
        val array = CharArray(s.length)
        for (i in array.indices) {
            array[indices[i]] = s[i]
        }
        return String(array)
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)
    println(
        Solution().restoreString("codeleet", array)
    )
}
