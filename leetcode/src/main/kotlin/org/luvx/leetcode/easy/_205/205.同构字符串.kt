package org.luvx.leetcode.easy._205

import org.luvx.coding.common.enhancer.out

/*
 * @lc app=leetcode.cn id=205 lang=kotlin
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    /**
     * egg add -> true
     * eggdd adddd -> false
     */
    open fun isIsomorphic(s: String, t: String): Boolean {
        val m: MutableMap<Any, Int> = HashMap()
        for (i in s.indices) {
            // 此处不等判断在 java 中涉及包装类
            if (m.put(s[i], i) != m.put(t[i].toString(), i)) {
                return false
            }
        }
        return true
    }

    fun isIsomorphic1(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val s2t = HashMap<Char, Char>()
        val t2s = HashMap<Char, Char>()
        for (i in s.indices) {
            val s1 = s[i]
            val t1 = t[i]
            val t2 = s2t.computeIfAbsent(s1) { t1 }
            val s2 = t2s.computeIfAbsent(t1) { s1 }
            if (s1 != s2 || t1 != t2) {
                return false
            }
        }
        return true
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    exec.isIsomorphic("egg", "add").out()
    exec.isIsomorphic("paper", "title").out()
    exec.isIsomorphic("eggdd", "adddd").out()
    exec.isIsomorphic("foo", "bar").out()
    exec.isIsomorphic("你哈哈", "我嘻嘻").out()
}