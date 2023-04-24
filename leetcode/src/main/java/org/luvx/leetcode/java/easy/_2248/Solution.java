package org.luvx.leetcode.java.easy._2248;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2248 lang=java
 *
 * [2248] 多个数组求交集
 */
// @lc code=start
class Solution {
    /**
     * <pre>
     *     [3,1,2,4,5]
     *     [1,2,3,4]
     *     [3,4,5,6]
     * </pre>
     * ↓
     * [3,4]
     */
    public List<Integer> intersection(int[][] nums) {
        int[] array = new int[1000];
        for (int[] num : nums) {
            for (int n : num) {
                array[n - 1] += 1;
            }
        }
        int size = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < size) {
                continue;
            }
            result.add(i + 1);
        }
        return result;
    }
}
// @lc code=end
