/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 *
 * https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (32.78%)
 * Total Accepted:    8.6K
 * Total Submissions: 26.2K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j
 * 的差的绝对值最大为 k。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 
 * 示例 3:
 * 
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * 
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) {
            return false;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= k; j++) {
                int kk = i + j;
                if (kk >= length || i == kk) {
                    continue;
                }
                if (nums[i] == nums[kk]) {
                    return true;
                }
            }
        }

        return false;
    }
}
