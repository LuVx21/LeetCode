package org.luvx.leetcode.java.easy._344;
/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        for (int i = 0, j = s.length - 1; i < j; ) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
// @lc code=end

