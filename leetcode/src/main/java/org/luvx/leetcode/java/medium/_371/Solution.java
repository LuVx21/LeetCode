package org.luvx.leetcode.java.medium._371;
/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 */

// @lc code=start
class Solution {
    /**
     * 1 0...01
     * 2 0...10
     * 3 0...11
     */
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        int sum = a;
        while (b != 0) {
            int carry = sum & b;// 为了处理11的位, 00还是0,10/01会在下步异或处理
            sum ^= b;// 求和, 仅处理10/01的情况
            b = carry << 1; // 进位, 11的位需变为0,前一位为1
        }

        return sum;
    }

    public int getSum1(int a, int b) {
        if (b == 0) {
            return a;
        }
        int x = a ^ b;// 不带进位和
        int y = (a & b) << 1;// 进位
        return y == 0 ? x : getSum1(x, y);
    }
}
// @lc code=end
