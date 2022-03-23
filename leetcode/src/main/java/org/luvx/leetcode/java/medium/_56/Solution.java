package org.luvx.leetcode.java.medium._56;
/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// @lc code=start
class Solution {
    /**
     * [1,3],[2,6],[8,10],[15,18]
     * [1,6],[8,10],[15,18]
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] first = intervals[0];
        result.add(first);
        for (int[] interval : intervals) {
            if (interval[0] <= first[1]) {
                first[1] = Math.max(first[1], interval[1]);
            } else {
                first = interval;
                result.add(first);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

// @lc code=end

