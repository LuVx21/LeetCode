package org.luvx.leetcode.java.easy._697;

/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    /**
     * 1,2,2,3,1 -> [2,2] -> 2
     * 1,2,2,3,1,4,2 -> [2,2,3,1,4,2] -> 6
     * <p>
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            int[] value = map.getOrDefault(k, new int[] {i, i, 0});
            value[1] = i;
            value[2]++;
            map.put(k, value);
        }

        int du = 0;
        int result = Integer.MAX_VALUE;
        for (Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            int _du = value[2];
            if (_du < du) {
                continue;
            }
            int len = value[1] - value[0];
            if (_du == du && len >= result) {
                continue;
            }
            result = len;
            du = _du;
        }

        return result + 1;
    }
}
// @lc code=end
