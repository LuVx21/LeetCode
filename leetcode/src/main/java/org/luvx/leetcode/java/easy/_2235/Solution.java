package org.luvx.leetcode.java.easy._2235;

/*
 * @lc app=leetcode.cn id=2235 lang=java
 *
 * [2235] 两整数相加
 */

// @lc code=start
class Solution {
    /**
     * 重复题目: No.371
     * {@link org.luvx.leetcode.java.medium._371.Solution#getSum(int, int)}
     */
    public int sum(int num1, int num2) {
          if (num1 == 0) {
            return num2;
        }
        if (num2 == 0) {
            return num1;
        }

        while (num2 != 0) {
            int carry = num1 & num2;
            num1 = num1 ^ num2;
            num2 = carry << 1;
        }

        return num1;
    }
}
// @lc code=end

