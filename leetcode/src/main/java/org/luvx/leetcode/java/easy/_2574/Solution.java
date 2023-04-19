package org.luvx.leetcode.java.easy._2574;

/*
 * @lc app=leetcode.cn id=2574 lang=java
 *
 * [2574] 左右元素和的差值
 */
// @lc code=start
class Solution {
    /**
     * 10,4,8,3
     * left: 0,10,14,22
     * right: 15,11,3,0
     */
    public int[] leftRigthDifference(int[] nums) {
        int leftSum = 0, rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            rightSum -= val;
            nums[i] = Math.abs(leftSum - rightSum);
            leftSum += val;
        }
        return nums;
    }

    public int[] leftRigthDifference2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 1; i < nums.length; i++) {
            result[0] = result[0] + nums[i];
        }
        int sum = result[0];
        for (int i = 1; i < nums.length; i++) {
            // 按照右边减左边计算
            sum = sum - nums[i] - nums[i - 1];
            result[i] = Math.abs(sum);
        }
        return result;
    }

    public int[] leftRigthDifferenceV1(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] left = new int[length], right = new int[length];
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] + nums[i - 1];
            right[length - 1 - i] = right[length - i] + nums[length - i];
        }
        for (int i = 0; i < left.length; i++) {
            result[i] = Math.abs(left[i] - right[i]);
        }
        return result;
    }
}
// @lc code=end

