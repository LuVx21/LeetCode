package org.luvx.leetcode.java.easy._674;

// @lc code=start
/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */
class Solution {
    /**
     * 无序数组, 最长连续递增长度
     * 1,3,5,4,7
     * 2,2,2,2,2
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int cnt = 0, temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                if (i == nums.length - 2) {
                    return Math.max(cnt + 1, temp + 2);
                }
                temp++;
            } else {
                cnt = Math.max(cnt, temp);
                temp = 0;
            }
        }
        return cnt + 1;
    }

    public int findLengthOfLCIS1(int[] nums) {
        int cnt = 1, temp = 1;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i] > nums[i - 1] ? temp + 1 : 1;
            cnt = Math.max(cnt, temp);
        }
        return nums.length == 0 ? 0 : cnt;
    }
}
// @lc code=end

