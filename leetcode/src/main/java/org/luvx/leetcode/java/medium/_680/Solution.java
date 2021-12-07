package org.luvx.leetcode.java.medium._680;

// @lc code=start

/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */
class Solution {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * abcdca -> acdca -> true
     */
    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindromic(s, l, r + 1) || isPalindromic(s, l - 1, r);
            }
        }
        return true;
    }

    private boolean isPalindromic(String s, int l, int r) {
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
