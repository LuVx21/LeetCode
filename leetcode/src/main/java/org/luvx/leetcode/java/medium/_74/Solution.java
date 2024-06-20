package org.luvx.leetcode.java.medium._74;
/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value = matrix[mid / n][mid % n];
            if (target < value) {
                end = mid - 1;
            } else if (target > value) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
