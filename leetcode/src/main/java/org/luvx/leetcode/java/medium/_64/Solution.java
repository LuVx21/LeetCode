package org.luvx.leetcode.java.medium._64;
/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start

class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        // 0-0位置到row-col位置的最小路径和
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 上方的
                int i1 = i == 0 ? 0 : dp[i - 1][j];
                // 左侧的
                int i2 = j == 0 ? 0 : dp[i][j - 1];
                int min = i != 0 && j != 0 ? Math.min(i1, i2) : i1 + i2;
                dp[i][j] = min + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public int minPathSum2(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        return min(grid, row - 1, col - 1);
    }

    private int min(int[][] grid, int row, int col) {
        if (row == 0 && col == 0) {
            return grid[row][col];
        }
        if (row == 0) {
            return grid[row][col] + min(grid, row, col - 1);
        }
        if (col == 0) {
            return grid[row][col] + min(grid, row - 1, col);
        }
        return grid[row][col] + Math.min(min(grid, row - 1, col), min(grid, row, col - 1));
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        // int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(exec.minPathSum(array));
    }
}
// @lc code=end

