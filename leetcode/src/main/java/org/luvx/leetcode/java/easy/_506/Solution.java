package org.luvx.leetcode.java.easy._506;
/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks1(int[] score) {
        // 存下标值, 题目要求数组最大为1w, 因此用short即可
        int[] indexArray = new int[100_0000 + 1];
        int min = score[0], max = score[0];
        for (int i = 0; i < score.length; i++) {
            indexArray[score[i]] = (i == 0 ? -1 : i);
            min = Math.min(min, score[i]);
            max = Math.max(max, score[i]);
        }

        String[] result = new String[score.length];
        int rank = 1;
        for (int i = max; i >= min; i--) {
            int index = indexArray[i];
            if (index == 0) {
                continue;
            }
            index = index == -1 ? 0 : index;
            if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank);
            }
            rank++;
        }

        return result;
    }
}
// @lc code=end

