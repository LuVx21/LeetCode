package org.luvx.leetcode.java.medium._221;
/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    /**
     * 动态规划优化
     */
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[] dp = new int[col + 1];
        int len = 0;

        for (char[] chars : matrix) {
            int leftUp = 0;
            for (int j = 0; j < col; j++) {
                int nextLeftUp = dp[j + 1];
                if (chars[j] == '1') {
                    dp[j + 1] = Math.min(Math.min(dp[j], dp[j + 1]), leftUp) + 1;
                    len = Math.max(len, dp[j + 1]);
                } else {
                    dp[j + 1] = 0;
                }
                leftUp = nextLeftUp;
            }
        }
        return len * len;
    }

    /**
     * 动态规划
     * F(i, j) = min{ F(i−1,j), F(i,j−1), F(i−1,j−1) } + 1
     */
    public int maximalSquare2(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        // dp[i][j]: 以 i 行 j 列为右下角所能构成的最大正方形边长
        // dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
        int[][] dp = new int[row + 1][col + 1];
        int len = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    continue;
                }
                dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                len = Math.max(len, dp[i][j]);
            }
        }

        return len * len;
    }

    /**
     * 记忆化搜索
     */
    public int maximalSquare1(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] memo = new int[row][col];
        int len = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                len = Math.max(len, searchMemo(matrix, i, j, memo));
            }
        }
        return len * len;
    }

    private int searchMemo(char[][] matrix, int x, int y, int[][] memo) {
        if (x >= matrix.length || y >= matrix[0].length || matrix[x][y] == '0') {
            return 0;
        }
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        int down = searchMemo(matrix, x + 1, y, memo);
        int right = searchMemo(matrix, x, y + 1, memo);
        int rightDown = searchMemo(matrix, x + 1, y + 1, memo);

        memo[x][y] = Math.min(Math.min(right, down), rightDown) + 1;
        return memo[x][y];
    }

    /**
     * 暴力
     */
    public int maximalSquare0(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length, len = Math.min(row, col);
        for (int l = len; l > 0; l--) {
            for (int i = 0; i <= row - l; i++) {
                for (int j = 0; j <= col - l; j++) {
                    if (matrix[i][j] == '0' || !isValid(i, j, l, matrix)) {
                        continue;
                    }
                    return l * l;
                }
            }
        }
        return 0;
    }

    private boolean isValid(int i, int j, int len, char[][] matrix) {
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if (matrix[row + i][col + j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
