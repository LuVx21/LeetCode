package org.luvx.leetcode.java.medium._3101;
/*
 * @lc app=leetcode.cn id=3101 lang=java
 *
 * [3101] 交替子数组计数
 */

// @lc code=start
class Solution {
    /**
     * 1 0 1 0
     * 4
     * 2元素: 10 01 10
     * 3元素: 101 010
     * 4元素: 1010
     */
    public long countAlternatingSubarrays1(int[] nums) {
        long r = 1, cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            r += cnt;
        }
        return r;
    }

    /**
     * 动态规划
     */
    public long countAlternatingSubarrays(int[] nums) {
        long r = 1;
        // add: 连续交替长度(中断重置为1)
        int add = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // 前一个不同
            if (num != nums[i - 1]) {
                r += ++add;
            } else {
                r += 1;
                add = 1;
            }
        }
        return r;
    }
}
// @lc code=end
