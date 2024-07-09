package org.luvx.leetcode.java.easy._3190;
/*
 * @lc app=leetcode.cn id=3190 lang=java
 *
 * [3190] 使所有元素都可以被 3 整除的最少操作数
 */

// @lc code=start
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int mod = num % 3;
            count += Math.min(mod, 3 - mod);
        }
        return count;
    }
}
// @lc code=end

