package org.luvx.leetcode.java.easy._415;
/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    /**
     * 456+9902=10358
     */
    public String addStrings(String num1, String num2) {
        String _long = num1, _short = num2;
        int cha = Math.abs(num1.length() - num2.length());
        if (num1.length() < num2.length()) {
            _long = num2;
            _short = num1;
        }

        int prefix = 0;
        StringBuilder result = new StringBuilder(_long);
        for (int i = _long.length() - 1; i >= 0; i--) {
            int i1 = _long.charAt(i) - '0';
            int i2 = i < cha ? 0 : _short.charAt(i - cha) - '0';
            int sum = prefix + i1 + i2;
            int i4 = sum % 10;
            prefix = sum / 10;
            result.setCharAt(i, (char) (i4 + '0'));
        }
        if (prefix > 0) {
            result.insert(0, (char) (prefix + '0'));
        }
        return result.toString();
    }

    public String addStrings1(String num1, String num2) {
        int len1 = num1.length() - 1, len2 = num2.length() - 1;

        int prefix = 0;
        StringBuilder result = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || prefix > 0) {
            int i1 = len1 >= 0 ? num1.charAt(len1--) - '0' : 0;
            int i2 = len2 >= 0 ? num2.charAt(len2--) - '0' : 0;
            int sum = prefix + i1 + i2;
            int i = sum % 10;
            prefix = sum / 10;
            result.insert(0, i);
        }
        return result.toString();
    }
}
// @lc code=end

