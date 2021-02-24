package org.luvx.leetcode.easy._14
/*
 * @lc app=leetcode.cn id=14 lang=kotlin
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val length = strs.size
        if (length == 0) {
            return ""
        }
        if (length == 1) {
            return strs[0]
        }
        val minLength = strs.map { it.length }.minOrNull()

        var result = ""
        for (i in 0 until minLength!!) {
            for (j in 0 until length - 1) {
                if (strs[j][i] != strs[j + 1][i]) {
                    return result
                }
                if (j + 1 == length - 1) {
                    result += strs[j][i]
                }
            }
        }
        return result
    }
}
// @lc code=end

