package org.luvx.leetcode.java.easy._1046;
/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        int r = stones.length - 1;
        for (; r >= 1; r--) {
            Arrays.sort(stones);
            stones[r - 1] = stones[r] - stones[r - 1];
        }
        return stones[0];
    }

    public int lastStoneWeight0(int[] stones) {
        int length = stones.length;
        if (length == 1) {
            return stones[0];
        }

        while (true) {
            Arrays.sort(stones);
            int max = stones[length - 1];
            int max2 = stones[length - 2];
            if ((max * max2) == 0) {
                return max;
            }
            stones[length - 1] = max - max2;
            stones[length - 2] = 0;
        }
    }
}
// @lc code=end
