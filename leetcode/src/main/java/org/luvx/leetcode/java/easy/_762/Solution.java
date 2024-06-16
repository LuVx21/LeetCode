package org.luvx.leetcode.java.easy._762;
/*
 * @lc app=leetcode.cn id=762 lang=java
 *
 * [762] 二进制表示中质数个计算置位
 */

// @lc code=start
class Solution {
    /**
     * 两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
     * 计算置位位数 就是二进制表示中 1 的个数
     */
    public int countPrimeSetBits(int left, int right) {
        // 题目要求, right最大为10^6, 其二进制长度为20
        boolean[] primes = new boolean[]{
                false, false, true, true, false,
                true, false, true, false, false,
                false, true, false, true, false,
                false, false, true, false, true, false
        };
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (primes[countBits(i)]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 参考: No.191
     */
    private int countBits(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = (n + (n >>> 8)) & 0x00ff00ff;
        n = (n + (n >>> 16)) & 0x0000ffff;
        return n;
    }
}
// @lc code=end
