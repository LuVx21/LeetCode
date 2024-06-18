package org.luvx.leetcode.java.easy._908;
/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start
class Solution {
    /**
     * 数组中每个数都可以+[-k,k]中的任一数字, 然后返回数组中max-min的最小值
     * <pre>
     *     根据题意，对于任意一个数 nums[i] 而言，其所能变化的范围为 [nums[i]−k,nums[i]+k]，我们需要最小化变化后的差值。
     *     而当 k 足够大时，我们必然能够将所有数变为同一个值，此时答案为 0，而更一般的情况，我们能够缩减的数值距离为 2*k，
     *     因此如果原来的最大差值为 d=max−min，若 d<=2*k 时，答案为 0，否则答案为 d−2*k。
     * </pre>
     */
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return Math.max(0, max - min - 2 * k);
    }
}
// @lc code=end

