package org.luvx.leetcode.java.medium._137;
/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public int singleNumber1(int[] nums) {
        int result = 0, mod = 3;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
                sum %= mod;
            }
            if (sum != 0) {
                result |= (sum) << i;
            }
        }
        return result;
    }
}
// @lc code=end
