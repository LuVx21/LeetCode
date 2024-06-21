package org.luvx.leetcode.java.medium._300;
/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    int result = 1;

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int max = 0;
        for (int num : nums) {
            int left = 0, right = max;
            while (left < right) {// 此处的二分查找, 找不到也定位到了 num 在有序 tails 中的位置
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            if (left == max) {
                max++;
            }
        }
        return max;
    }

    /**
     * 动态规划
     */
    public int lengthOfLIS0(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 超时: 性能问题
     */
    public int lengthOfLIS1(int[] nums) {
        helper(new ArrayList<>(), 0, nums);
        return result;
    }

    private void helper(List<Integer> list, int index, int[] nums) {
        if (list.size() >= 2 && list.size() > result) {
            result = list.size();
        }
        for (int i = index; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) < nums[i]) {
                list.add(nums[i]);
                helper(list, i + 1, nums);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        List.of(
                new int[] {7, 7, 7, 7, 7, 7, 7},
                new int[] {0, 1, 0, 3, 2, 3},
                new int[] {10, 9, 2, 5, 3, 7, 101, 18}
        ).forEach(array ->
                System.out.println(exec.lengthOfLIS(array))
        );
    }
}
// @lc code=end

