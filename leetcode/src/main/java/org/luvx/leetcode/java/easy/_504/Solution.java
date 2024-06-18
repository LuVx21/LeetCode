package org.luvx.leetcode.java.easy._504;

/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    final char[] digits = {'0', '1', '2', '3', '4', '5', '6'};

    public String convertToBase7(int num) {
        // return Integer.toString(num, 7);
        int n = Math.abs(num);
        byte[] buf = new byte[33];
        int index = 32;
        while (n >= 7) {
            buf[index--] = (byte) digits[n % 7];
            n /= 7;
        }
        buf[index] = (byte) digits[n];
        if (num < 0) {
            buf[--index] = '-';
        }
        byte[] bytes = Arrays.copyOfRange(buf, index, index + (33 - index));
        return new String(bytes);
    }

    /**
     * 202(7进制) -> 2*7^0 + 0*7^1 + 2*7^2 -> 100(十进制)
     */
    public String convertToBase7_0(int num) {
        if (num == 0) {
            return "0";
        }
        int n = Math.abs(num);

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 7);
            n /= 7;
        }

        if (num < 0) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public String convertToBase7_1(int num) {
        int n = num >= 0 ? num : -num;
        if (n <= 6) {
            return String.valueOf(num);
        }
        final int remix = 7;
        int max = 0, ji = 1;
        for (; ji * remix <= n; max++) {
            ji *= remix;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = max; i >= 0; i--) {
            int pow = (int) Math.pow(remix, i);
            sb.append(n / pow);
            n %= pow;
        }

        if (num < 0) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }
}
// @lc code=end
