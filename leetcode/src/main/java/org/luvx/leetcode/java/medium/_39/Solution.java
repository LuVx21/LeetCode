package org.luvx.leetcode.java.medium._39;
/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    /**
     * 2,3,5=8 -> [2,2,2,2],[2,3,3],[3,5]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        backtrack(candidates, target, new ArrayList<>(), 0, result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, List<Integer> sum, int start, List<List<Integer>> result) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(sum));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            sum.add(candidates[i]);
            // start not i + 1 because we can reuse same elements
            backtrack(candidates, remain - candidates[i], sum, i, result);
            sum.removeLast();
        }
    }
}
// @lc code=end

