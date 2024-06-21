package org.luvx.leetcode.java.medium._47;
/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    /**
     * 1,1,2
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        var result = new ArrayList<List<Integer>>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> list, boolean[] used, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, list, used, result);
            used[i] = false;
            list.removeLast();
        }
    }
}
// @lc code=end

