package org.luvx.leetcode.easy._1768

import org.luvx.leetcode.out

/*
 * @lc app=leetcode.cn id=1768 lang=kotlin
 *
 * [1768] 交替合并字符串
 */

// @lc code=start
class Solution {

    fun mergeAlternately(word1: String, word2: String): String {
        val sb = StringBuilder(word1.length + word2.length)

        // for (i in 0 until maxOf(word1.length, word2.length)) {
        //     if (i < word1.length) sb.append(word1[i])
        //     if (i < word2.length) sb.append(word2[i])
        // }

        var (i, j) = 0 to 0
        while (true) {
            if (i < word1.length) sb.append(word1[i++])
            if (j < word2.length) sb.append(word2[j++])
            if (i == word1.length && j == word2.length) break
        }

        return sb.toString()
    }

    /**
     * 给你两个字符串 word1 和 word2 。
     * 请你从 word1 开始，通过交替添加字母来合并字符串。
     * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。返回 合并后的字符串 。
     *
     * abc pqr -> apbqcr
     */
    fun mergeAlternately1(word1: String, word2: String): String {
        val array = CharArray(word1.length + word2.length)
        var i = 0
        var i1 = 0
        var i2 = 0
        while (i1 < word1.length && i2 < word2.length) {
            array[i++] = word1[i1++]
            array[i++] = word2[i2++]
        }
        while (i1 < word1.length) {
            array[i++] = word1[i1++]
        }
        while (i2 < word2.length) {
            array[i++] = word2[i2++]
        }
        return String(array)
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    exec.mergeAlternately("hello", "world").out()
    exec.mergeAlternately("abc", "pqr").out()
    exec.mergeAlternately("ab", "pqrs").out()
    exec.mergeAlternately("abcd", "pq").out()
}

