package org.luvx.leetcode.java.easy._766;
/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    /**
     * <pre>
     *  1  2  3  4
     *  5  1  2  3
     *  9  5  1  2
     *  --------
     *  1  2  3  4
     *  5  1  2  3
     *  9  5  1  2
     *  4  9  5  1
     *  7  4  9  5
     * </pre>
     * 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 左下角和右上角可以跳过
        int row = matrix.length - 2, col = 0;
        while (row >= 0 && col < n - 1) {
            int r = row, c = col;
            int value = matrix[r++][c++];
            while (r < m && c < n) {
                if (value != matrix[r][c]) {
                    return false;
                }
                // 邻近右下角
                r++;
                c++;
            }
            if (row == 0) {
                col++;
            }
            if (row > 0) {
                row--;
            }
        }
        return true;
    }
}
// @lc code=end
