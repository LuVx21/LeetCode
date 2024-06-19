package org.luvx.leetcode.java.medium._739;
/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    /**
     * <pre>
     * 89,62,70,58,47,47,46,76,100,70
     *  8, 1, 5, 4, 3, 2, 1, 1,  0, 0
     * </pre>
     * 关联: No.496, 区别在本题会有重复
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] r = new int[temperatures.length];
        // 存索引
        int index = 0;
        int[] stack = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int num = temperatures[i];
            // 可能有重复, 这里需要等于
            while (index > 0 && temperatures[stack[index - 1]] <= num) {
                index--;
            }
            r[i] = index <= 0 ? 0 : stack[index - 1] - i;
            stack[index++] = i;
        }

        return r;
    }
}
// @lc code=end
