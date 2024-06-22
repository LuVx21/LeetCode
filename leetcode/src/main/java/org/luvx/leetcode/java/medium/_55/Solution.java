package org.luvx.leetcode.java.medium._55;
/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    /**
     * <pre>
     *     2,0,1,1,4 -> true
     *     2,3,1,1,4 -> true
     *     3,2,1,0,4 -> false
     * </pre>
     * #贪心
     */
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        int n = 1, len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

