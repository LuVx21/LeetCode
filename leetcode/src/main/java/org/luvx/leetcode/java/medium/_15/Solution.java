package org.luvx.leetcode.java.medium._15;
/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    /**
     * 1. 排序
     * 2. 对i元素后面的所有进行查找相加比较
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(0);
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int start = i + 1, end = nums.length - 1, sum = -nums[i];
                while (start < end) {
                    if (nums[start] + nums[end] == sum) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] < sum) {
                        start++;
                    } else if (nums[start] + nums[end] > sum) {
                        end--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-4, -1, -1, 0, 1, 2};
        Solution exec = new Solution();
        System.out.println(exec.threeSum(array));
    }
}
// @lc code=end

