package org.luvx.leetcode.kotlin.easy._1668

import org.luvx.coding.common.enhancer.out

/*
 * @lc app=leetcode.cn id=1668 lang=kotlin
 *
 * [1668] 最大重复子字符串
 */

// @lc code=start
class Solution {
    /**
     * 给你一个字符串 sequence，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。
     * 单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。
     * 如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
     * 给你一个字符串 sequence 和 word，请你返回 最大重复值 k 。
     * ababc ab/ba/ac
     */
    fun maxRepeating(sequence: String, word: String): Int {
        val len1 = sequence.length
        val len2 = word.length
        if (len1 == len2 && sequence == word) {
            return 1
        }

        var max = 0
        var i = 0
        while (i <= len1 - len2) {
            if (sequence[i] == word[0]) {
                var tempCount = 0
                var j = i
                while (j <= len1 - len2 && equals(sequence, j, j + len2, word)) {
                    j += len2
                    tempCount++
                }
                max = maxOf(max, tempCount)
            }
            i++
        }
        return max
    }

    /**
     * sequence 的 start..end 是否与word相同
     */
    fun equals(sequence: String, start: Int, end: Int, word: String): Boolean {
        if (end - start != word.length) {
            return false
        }
        for (i in start until end) {
            if (sequence[i] != word[i - start]) {
                return false
            }
        }
        return true
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    exec.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba").out()
    exec.maxRepeating("ababc", "ab").out()
    exec.maxRepeating("ababc", "ba").out()
    exec.maxRepeating("ababc", "ac").out()
    exec.maxRepeating("aaaaaa", "aa").out()
    exec.maxRepeating("aa", "aa").out()
}