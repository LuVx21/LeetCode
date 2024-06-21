package org.luvx.leetcode.java.medium._90;
/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        var result = new ArrayList<List<Integer>>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(result, list, nums, i + 1);
            list.removeLast();
        }
    }
}
// @lc code=end

