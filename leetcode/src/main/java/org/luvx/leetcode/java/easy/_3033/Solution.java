package org.luvx.leetcode.java.easy._3033;
/*
 * @lc app=leetcode.cn id=3033 lang=java
 *
 * [3033] 修改矩阵
 */

import com.alibaba.fastjson2.JSON;

// @lc code=start
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] r = new int[row][col];

        for (int j = 0; j < col; j++) {
            int max = Integer.MIN_VALUE, curMax = matrix[0][j];
            for (int i = 0; i < row; i++) {
                int num = matrix[i][j];
                curMax = Math.max(curMax, num);
                if (num != -1) {
                    r[i][j] = matrix[i][j];
                    continue;
                }
                if (max == Integer.MIN_VALUE) {
                    max = curMax;
                    for (int k = i + 1; k < row; k++) {
                        max = Math.max(max, matrix[k][j]);
                    }
                }
                r[i][j] = max;
            }
        }
        return r;
    }

    public void main(String[] args) {
        // int[][] attay = {{1, 2, -1}, {4, -1, 6}, {7, 8, 9}};
        int[][] attay = {{1, 2, -1}, {4, -1, 6}, {7, 8, 9}};
        int[][] ints = modifiedMatrix(attay);
        System.out.println(JSON.toJSONString(ints));
    }
}
// @lc code=end
