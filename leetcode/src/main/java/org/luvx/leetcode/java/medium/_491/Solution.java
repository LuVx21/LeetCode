package org.luvx.leetcode.java.medium._491;
/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    /**
     * 回溯法
     * 4,6,7,7
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int index, int[] nums) {
        if (list.size() >= 2) {
            result.add(new ArrayList<>(list));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                used.add(nums[i]);
                list.add(nums[i]);
                helper(result, list, i + 1, nums);
                list.removeLast();
            }
        }
    }


    public List<List<Integer>> findSubsequences1(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        findSequence(res, new ArrayList<>(), 0, nums);
        return new ArrayList<>(res);
    }

    public void findSequence(Set<List<Integer>> result, List<Integer> list, int index, int[] nums) {
        if (list.size() >= 2) {
            result.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                findSequence(result, list, i + 1, nums);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        int[] array = {4, 6, 7, 7};
        List<List<Integer>> subsequences = exec.findSubsequences(array);
        System.out.println(subsequences);
    }
}
// @lc code=end
