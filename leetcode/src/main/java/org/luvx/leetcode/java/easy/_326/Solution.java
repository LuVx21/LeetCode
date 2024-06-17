package org.luvx.leetcode.java.easy._326;
/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        // 3^19
        // return n > 0 && 1162261467 % n == 0;

        // 数学
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean isPowerOfThree1(int n) {
        if (n <= 0) {
            return false;
        }
        while (n >= 3) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }
}
// @lc code=end

