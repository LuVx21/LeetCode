package org.luvx.question.dp;

/**
 * 环节点的走法数
 */
public class RingPaceNum {
    /**
     * 长度为ringLen的环, 编号为 0...ringLen-1
     * 可以顺时针也可以逆时针走一步
     * 经过 n 步从新回到 0 节点总共有多少走法
     * #动态规划
     */
    private int paceNum(int ringLen, int n) {
        // 二维数组的下标(i,j): 第 i 步走到第 j 节点
        int[][] dp = new int[n + 1][ringLen];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < ringLen; j++) {
                // 走 i 步到 j 的方案=(i-1)步走到 j 的后一个 + (i-1)步走到 j 的前一个
                dp[i][j] = dp[i - 1][(j + 1) % ringLen] + dp[i - 1][(j - 1 + ringLen) % ringLen];
            }
        }
        return dp[n][0];
    }
}
