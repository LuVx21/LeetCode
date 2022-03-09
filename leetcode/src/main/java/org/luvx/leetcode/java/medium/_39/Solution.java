package org.luvx.leetcode.java.medium._39;
/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 2,3,5=8 -> [2,2,2,2],[2,3,3],[3,5]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            // start not i + 1 because we can reuse same elements
            backtrack(result, list, candidates, remain - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        System.out.println(exec.combinationSum(new int[] {2, 3, 5}, 8));
    }
}
// @lc code=end

