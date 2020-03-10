/*
 * @lc app=leetcode.cn id=1072 lang=java
 *
 * [1072] 按列翻转得到最大值等行数
 */

// @lc code=start
class Solution {
    /**
     * 分析下来:
     * 1. 返回值肯定>=1
     * 2. 某两行最终都能行内所有值都相等, 这两行相同或者相反
     * 3. 2的基础上, 将所有行全部处理成0开头的, 那么相反的就会变成相同的, 那么问题可以转化为数组内,元素最大重复次数的计算
     * <pre>
     *     0 0 0
     *     0 0 1
     *     1 1 0 -> 0 0 1
     * </pre>
     *
     * @param matrix
     * @return
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        matrix = aa(matrix);
        int count = 0, rowNum = matrix.length, colNum = matrix[0].length;

        boolean[] hasCheck = new boolean[rowNum];
        for (int i = 0; i < rowNum; i++) {
            if (hasCheck[i]) {
                continue;
            }
            int cnt = 1;
            hasCheck[i] = true;
            for (int i1 = i + 1; i1 < rowNum; i1++) {
                if (Arrays.equals(matrix[i], matrix[i1])) {
                    cnt++;
                    hasCheck[i1] = true;
                }
            }
            count = Math.max(count, cnt);
        }

        return count;
    }

    private int[][] aa(int[][] matrix) {
        for (int[] row : matrix) {
            if (row[0] == 1) {
                for (int i = 0; i < row.length; i++) {
                    row[i] ^= 1;
                }
            }
        }
        return matrix;
    }

    public int maxEqualRowsAfterFlips1(int[][] matrix) {
        int count = 0, rowNum = matrix.length, colNum = matrix[0].length;
        int[] flip = new int[colNum];
        for (int i = 0; i < rowNum; i++) {
            int cnt = 0;
            for (int j = 0; j < colNum; j++) {
                flip[j] = 1 - matrix[i][j];
            }
            for (int k = 0; k < rowNum; k++) {
                if (Arrays.equals(matrix[k], matrix[i]) || Arrays.equals(matrix[k], flip)) {
                    cnt++;
                }
            }
            count = Math.max(count, cnt);
        }
        return count;
    }
}
// @lc code=end

