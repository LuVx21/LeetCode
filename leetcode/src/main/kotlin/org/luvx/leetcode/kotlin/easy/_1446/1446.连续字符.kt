package org.luvx.leetcode.kotlin.easy._1446
/*
 * @lc app=leetcode.cn id=1446 lang=kotlin
 *
 * [1446] 连续字符
 */

// @lc code=start
class Solution {
    /**
     * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
     * 请你返回字符串的能量。
     * 01234567
     * leetcode
     * ccbccbb
     */
    fun maxPower(s: String): Int {
        var max = 0
        var cnt = 1
        for (i in s.indices) {
            if (i < s.length - 1 && s[i] == s[i + 1]) {
                cnt++
            } else {
                if (cnt > max) {
                    max = cnt
                }
                cnt = 1
            }
        }
        return max
    }

    fun maxPower0(s: String): Int {
        var max = 1
        var i = 0
        while (true) {
            var cnt = 1
            var j = i + 1
            while (j < s.length) {
                if (s[i] == s[j]) {
                    cnt++
                    j++
                } else {
                    i = j
                    break
                }
            }
            if (cnt > max) {
                max = cnt
            }
            if (i == s.length - 1 || j >= s.length - 1) {
                return max
            }
        }
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    arrayOf(
        "leetcode", "abbcccddddeeeeedcba", "triplepillooooow", "hooraaaaaaaaaaay", "tourist",
        "ccbccbb"
    ).forEach { s -> println(exec.maxPower(s)) }
}