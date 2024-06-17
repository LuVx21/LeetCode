package org.luvx.leetcode.java.medium._477;
/*
 * @lc app=leetcode.cn id=477 lang=java
 *
 * [477] 汉明距离总和
 */

// @lc code=start
class Solution {
    /**
     * <pre>
     * 4  0100
     * 14 1110
     * 2  0010
     * </pre>
     * 关联:<br/>
     * No.137 {@link org.luvx.leetcode.java.medium._137.Solution#singleNumber(int[])}
     * <br/>
     * No.461{@link org.luvx.leetcode.java.easy._461.Solution#hammingDistance(int, int)}
     */
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        // 题目要求,数字的范围为[0,10^9],因此最大位数为30即可,不用32
        for (int i = 0; i < 30; i++) {
            // i位上1的数量
            int oneCnt = 0;
            for (int num : nums) {
                oneCnt += (num >> i) & 1;
            }
            // i位上,1的数量*0的数量
            sum += oneCnt * (nums.length - oneCnt);
        }
        return sum;
    }
}
// @lc code=end
