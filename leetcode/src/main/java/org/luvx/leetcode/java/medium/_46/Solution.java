package org.luvx.leetcode.java.medium._46;
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    /**
     * 1,2,3
     */
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            backtrack(nums, list, result);
            list.removeLast();
        }
    }
}
// @lc code=end

