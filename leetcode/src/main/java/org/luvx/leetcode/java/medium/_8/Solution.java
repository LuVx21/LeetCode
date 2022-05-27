package org.luvx.leetcode.java.medium._8;
/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */
// @lc code=start

import java.util.stream.Stream;

class Solution {
    /**
     * -2147483648 ~ 2147483647
     */
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int len = str.length();
        int prefix = 1, value = 0, i = 0;
        while (i < len && str.charAt(i) == ' ') {
            i++;
        }
        if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            prefix = str.charAt(i++) == '-' ? -1 : 1;
        }

        while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (value > Integer.MAX_VALUE / 10 || (value == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return prefix == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value = 10 * value + (str.charAt(i++) - '0');
        }
        return value * prefix;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        Stream.of(
                        " ",
                        "   -42",
                        "4193 with words",
                        " +-42"
                )
                .map(exec::myAtoi)
                .forEach(System.out::println);
    }
}
// @lc code=end

