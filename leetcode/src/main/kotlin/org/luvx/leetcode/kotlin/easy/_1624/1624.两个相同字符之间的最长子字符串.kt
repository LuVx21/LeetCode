package org.luvx.leetcode.kotlin.easy._1624
/*
 * @lc app=leetcode.cn id=1624 lang=kotlin
 *
 * [1624] 两个相同字符之间的最长子字符串
 */

// @lc code=start
class Solution {
    /**
     *给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度，
     * 计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
     * 子字符串是字符串中的一个连续字符序列。
     */
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val len = s.length
        var max = -1
        for (i in 0..len - 2) {
            for (j in len - 1 downTo i + 1) {
                if (s.elementAt(i) == s.elementAt(j)) {
                    val i1 = j - i - 1
                    max = if (max != -1) if (max >= i1) max else i1 else i1
                    if (i + max >= len - 2) {
                        return max
                    }
                }
            }
        }
        return max
    }

    fun maxLengthBetweenEqualCharacters1(s: String): Int {
        var max = -1
        val map: MutableMap<Char, Int> = mutableMapOf()
        for (i in s.indices) {
            val c: Char = s.elementAt(i)
            if (map.containsKey(c)) {
                val i1 = i - 1 - map[c]!!
                max = if (max >= i1) max else i1
            } else {
                map[c] = i
            }
        }
        return max
    }
}
// @lc code=end

fun main() {
    val array = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    val exec = Solution()
    println(exec.maxLengthBetweenEqualCharacters("aaaaaaa"))
    println(exec.maxLengthBetweenEqualCharacters("aabcdefg"))
//    println(exec.maxLengthBetweenEqualCharacters("cabbac"))
//    println(exec.maxLengthBetweenEqualCharacters("cabdzz"))
//    println(exec.maxLengthBetweenEqualCharacters("ccbdzb"))
//    println(exec.maxLengthBetweenEqualCharacters("ccbdzc"))
}