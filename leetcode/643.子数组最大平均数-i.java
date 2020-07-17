/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = Integer.MIN_VALUE, temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (i >= k - 1) {
                sum = Math.max(sum, temp);
                temp -= nums[i - k + 1];
            }
        }

        return Double.valueOf(sum) / k;
    }

    public double findMaxAverage1(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int temp = sum;
        for (int i = 1; i <= nums.length - k; i++) {
            temp = temp - nums[i - 1] + nums[i + k - 1];
            sum = Math.max(temp, sum);
        }

        return Double.valueOf(sum) / k;
    }
}
// @lc code=end

