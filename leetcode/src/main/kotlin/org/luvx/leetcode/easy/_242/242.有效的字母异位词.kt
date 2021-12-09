package org.luvx.leetcode.easy._242

import org.luvx.leetcode.out

// @lc code=start
/*
 * @lc app=leetcode.cn id=242 lang=kotlin
 *
 * [242] 有效的字母异位词
 */
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val hashMap = HashMap<Char, Int>()
        for (i in s.indices) {
            hashMap.compute(s[i]) { _, v: Int? -> (v ?: 0) + 1 }
            hashMap.compute(t[i]) { _, v: Int? -> (v ?: 0) - 1 }
        }

        for (value in hashMap.values) {
            if (value != 0) {
                return false
            }
        }
        return true
    }

    /**
     * 不支持 unicode
     */
    fun isAnagram0(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val cArray = IntArray(26)
        for (i in s.indices) {
            cArray[s[i] - 'a']++
            cArray[t[i] - 'a']--
        }
        for (i in cArray) {
            if (i != 0) {
                return false
            }
        }
        return true
    }
}

// @lc code=end

fun main() {
    val exec = Solution()
    exec.isAnagram("anagram", "nagaram").out()
    exec.isAnagram("rat", "car").out()
    exec.isAnagram("你,好", "好你,").out()
}