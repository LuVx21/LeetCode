package org.luvx.leetcode.java.easy._228;
/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    /**
     * 0,1,2,4,5,7 -> ["0->2","4->5","7"]
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        var r = new LinkedList<String>();
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length - 1 && nums[j + 1] - nums[j] == 1) {
                j++;
            }
            String s = j > i ? nums[i] + "->" + nums[j] : String.valueOf(nums[i]);
            r.add(s);
            i = j + 1;
        }
        return r;
    }
}
// @lc code=end
