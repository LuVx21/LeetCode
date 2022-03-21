package org.luvx.leetcode.java.medium._54;
/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * <pre>
     *      0  1  2  3
     *   0 [1, 2, 3, 4]
     *   1 [5, 6, 7, 8]
     *   2 [9,10,11,12]
     *     ↓
     *     1,2,3,4,8,12,11,10,9,5,6,7
     * </pre>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return emptyList();
        }
        List<Integer> result = new ArrayList<>();
        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(exec.spiralOrder(array));
    }
}
// @lc code=end

