package org.luvx.leetcode.java.medium._7;
/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        return Integer.MIN_VALUE <= r && r <= Integer.MAX_VALUE ? (int) r : 0;
    }

    public int reverse0(int x) {
        int r = 0;
        while (x != 0) {
            int tail = x % 10;
            int nr = r * 10 + tail;
            if ((nr - tail) / 10 != r) {// 是否在范围内
                return 0;
            }
            r = nr;
            x /= 10;
        }
        return r;
    }

    public int reverse1(int x) {
        String v = "";
        if (x < 0) {
            v = Integer.toString(x).substring(1);
        } else {
            v = Integer.toString(x);
        }
        v = (x < 0 ? "-" : "") + new StringBuffer(v).reverse();
        return Integer.parseInt(v);
    }
}
// @lc code=end

