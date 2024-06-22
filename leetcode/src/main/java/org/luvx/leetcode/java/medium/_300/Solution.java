package org.luvx.leetcode.java.medium._300;
/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    int result = 1;

    /**
     * dp[i]的结果计算并不依赖dp[i-1]
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = Integer.MIN_VALUE;
        dp[1] = nums[0];
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (dp[max] < nums[i]) {
                max++;
                dp[max] = nums[i];
                continue;
            }

            for (int j = max - 1; j >= 0; j--) {
                if (nums[i] > dp[j]) {
                    dp[j + 1] = nums[i];
                    break;
                }
            }
        }
        return max;
    }

    /**
     * 动态规划(最容易理解, 但时间复杂度在n^2)
     */
    public int lengthOfLIS0(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 10, 9, 2, 5, 3, 7, 101, 18
     * tails: [2, 3, 7, 18, 0, 0, 0, 0]
     */
    public int lengthOfLIS2(int[] nums) {
        // 每一项 p[i] 的含义是，所有长度为 i+1 的上升子序列的末尾元素中的最小值
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int max = 1; // 因为用于下标, [left,max]所表示的数据范围长度为max+1
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // [0, 目前最长的地方] 范围内查找
            int left = 0, right = max;
            // 此处的二分查找, 最终是定位left值(num 在有序 tails 中的位置)
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    // 进入这里,说明是递增, tails才会增加元素, 子序列长度才会增加
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 放入递增子序列中, 如果遇到nums中的降序, 这个位置会被覆盖
            tails[left] = num;
            // left已经到了tails的右边界,长度加一
            if (left == max) {
                max++;
            }
        }
        return max;
    }

    /**
     * 超时: 性能问题
     */
    public int lengthOfLIS1(int[] nums) {
        backtrack(new ArrayList<>(), 0, nums);
        return result;
    }

    private void backtrack(List<Integer> list, int index, int[] nums) {
        if (list.size() >= 2 && list.size() > result) {
            result = list.size();
        }
        for (int i = index; i < nums.length; i++) {
            if (list.isEmpty() || list.getLast() < nums[i]) {
                list.add(nums[i]);
                backtrack(list, i + 1, nums);
                list.removeLast();
            }
        }
    }
}
// @lc code=end

