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
        int cnt = 1, temp = 1;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i] > nums[i - 1] ? temp + 1 : 1;
            cnt = Math.max(cnt, temp);
        }
        return nums.length == 0 ? 0 : cnt;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        int[] array = {2, 2, 2, 2, 2};
        System.out.println(exec.findLengthOfLCIS(array));
    }
}
// @lc code=end

