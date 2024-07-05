package org.luvx.leetcode.java.easy._414;
/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 */

// @lc code=start
class Solution {
    /**
     * 2 2 3 1
     * 性能好, 避免了拆装箱
     */
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE, max2 = max1, max3 = max1;
        for (long num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max1 > num && num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max2 > num && num > max3) {
                max3 = num;
            }
        }
        return max3 == Long.MIN_VALUE ? (int) max1 : (int) max3;
    }
}
// @lc code=end
