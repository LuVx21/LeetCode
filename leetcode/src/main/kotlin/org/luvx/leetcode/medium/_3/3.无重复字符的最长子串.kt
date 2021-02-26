package org.luvx.leetcode.medium._3

import org.luvx.leetcode.out

/*
 * @lc app=leetcode.cn id=3 lang=kotlin
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val length = s.length
        if (length == 0 || length == 1) {
            return length
        }

        val map = hashMapOf<Char, Int>()
        var (max, i, start) = intArrayOf(0, 0, 0)
        while (i < length) {
            val key = s[i]
            start = maxOf(map[key] ?: start, start)
            map[key] = ++i
            max = maxOf(max, i - start)
        }
        return max
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 最长非重复子串
     * abcabcbb -> abc
     * abcdbabcbb -> abcd
     * pwwkew -> wke
     */
    fun lengthOfLongestSubstring0(s: String): Int {
        val length = s.length
        if (length == 0 || length == 1) {
            return length
        }
        val set: MutableSet<Char> = hashSetOf<Char>()
        var max = 0
        var i = 0
        var j = 0
        while (i < length) {
            if (set.contains(s[i])) {
                set.remove(s[j++])
            } else {
                set.add(s[i++])
                max = maxOf(max, set.size)
            }
        }
        return max
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    arrayOf("abcabcbb", "abcdbabcbb", "pwwkew", "dvdf", "abcdb").forEach {
        out(
            exec.lengthOfLongestSubstring0(it),
            exec.lengthOfLongestSubstring(it)
        )
    }
}