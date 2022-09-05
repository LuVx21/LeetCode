package org.luvx.leetcode.java.easy._389;

/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start
class Solution {
    /**
     * 实现方式:
     * 1. t 的字符相加和减去 s 的字符相加和(巧合, 不具有通用性)
     * 2. 异或
     * 3. set 等容器
     * 4. 仅有小写字母的 26 长度的数组
     */
    public char findTheDifference(String s, String t) {
        return m2(s, t);
    }

    private char m2(String s, String t) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            result ^= t.charAt(i);
        }
        return (char) result;
    }

    private char m1(String s, String t) {
        int sum = 0;
        for (int i = 0; i < t.length(); i++) {
            sum += t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            sum -= s.charAt(i);
        }
        return (char) sum;
    }
}
// @lc code=end
