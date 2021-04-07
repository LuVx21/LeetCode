package org.luvx.leetcode.java.easy._1;

// @lc code=start
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
        // int length = nums.length;
        // for (int i = 0; i < length; i++) {
        //     for (int j = i + 1; j < length; j++) {
        //         if (target - nums[i] == nums[j]) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return null;
    }
}
// @lc code=end
