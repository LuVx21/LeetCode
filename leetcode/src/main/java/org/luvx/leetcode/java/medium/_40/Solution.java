package org.luvx.leetcode.java.medium._40;
/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    /**
     * 10,1,2,7,6,1,5=8 -> [1,1,6],[1,2,5],[1,7],[2,6]
     *
     * @param candidates 元素可能重复, 且其中元素只能只能用一次
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 可能重复,先排序
        Arrays.sort(candidates);

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
            // 元素重复可能导致结果中有相同的组合
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], sum, i + 1, result);
            sum.removeLast();
        }
    }
}
// @lc code=end

