package org.luvx.leetcode.java.easy._231;
/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        char[] array = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for (char c : array) {
            if (c == '1') {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
// @lc code=end

