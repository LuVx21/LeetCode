package org.luvx.leetcode.java.easy._1374;

// @lc code=start
/*
 * @lc app=leetcode.cn id=1374 lang=java
 *
 * [1374] 生成每种字符都是奇数个的字符串
 */
class Solution {
    public String generateTheString(int n) {
        char[] array = new char[n];
        int cnt = n % 2 == 0 ? n - 1 : n;
        for (int i = 0; i < cnt; i++) {
            array[i] = 'a';
        }
        if (n % 2 == 0) {
            array[n - 1] = 'b';
        }
        return String.valueOf(array);
    }
}
// @lc code=end

