package org.luvx.leetcode.java.medium._78;
/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    /**
     * 1,2,3 -> [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]
     */
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(result, list, nums, i + 1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = exec.subsets(nums);
        System.out.println(result);
    }
}
// @lc code=end

