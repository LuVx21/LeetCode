package org.luvx.leetcode.easy._459

import org.luvx.coding.common.enhancer.out

/*
 * @lc app=leetcode.cn id=459 lang=kotlin
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
     * 给定的字符串只含有小写英文字母，并且长度不超过10000。
     */
    fun repeatedSubstringPattern(s: String): Boolean {
        val len = s.length
        loop@ for (group in len downTo 2) {
            if (len % group != 0) {
                continue
            }
            val nums = len / group
            for (i in 0 until nums) {
                val temp = s[i]
                for (j in 1 until group) {
                    if (s[j * nums + i] != temp) {
                        continue@loop
                    }
                    if (i == nums - 1 && j == group - 1) {
                        return true
                    }
                }
            }
        }
        return false
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    val array = arrayOf("abcabcabcabc", "abcabcabc", "ababab", "abab", "bb", "aba")
    array.forEach { s -> exec.repeatedSubstringPattern(s).out() }
}
