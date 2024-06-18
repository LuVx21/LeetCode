package org.luvx.leetcode.kotlin.easy._1662
/*
 * @lc app=leetcode.cn id=1662 lang=kotlin
 *
 * [1662] 检查两个字符串数组是否相等
 */

// @lc code=start
class Solution {
    /**
     * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
     * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
     * ["ab", "c"], ["a", "bc"]
     */
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        var i1 = 0
        var i2 = 0
        var w1 = ""
        var w2 = ""
        var j1 = 0
        var j2 = 0
        while (true) {
            if (j1 >= w1.length) {
                if (i1 >= word1.size) {
                    return j2 >= w2.length && i2 >= word2.size
                }
                w1 = word1[i1++]
                j1 = 0
            }
            if (j2 >= w2.length) {
                if (i2 >= word2.size) {
                    return j1 >= w1.length && i1 >= word1.size
                }
                w2 = word2[i2++]
                j2 = 0
            }
            if (w1[j1++] != w2[j2++]) {
                return false
            }
        }
//         return word1.joinToString(separator = "") == word2.joinToString(separator = "")
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    val array1 = arrayOf("ab", "c")
    val array2 = arrayOf("a", "bc", "c")
    println(
        exec.arrayStringsAreEqual(array1, array2)
    )
}