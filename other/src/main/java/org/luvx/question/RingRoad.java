package org.luvx.question;

import java.util.Arrays;

public class RingRoad {
    /**
     * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
     * https://leetcode-cn.com/circle/discuss/TWO4Z5/
     * <p>
     * 参考: leetcode70-爬楼梯
     */
    public int ringRoad(int n) {
        int length = 10;
        // dp[i][j]为从0点出发走i步到j点的方案数
        int[][] dp = new int[n + 1][length];
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            int[] a = dp[i - 1];
            for (int j = 0; j < length; j++) {
                dp[i][j] = a[(j - 1 + length) % length] + a[(j + 1) % length];
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        RingRoad exec = new RingRoad();
        System.out.println(
                exec.ringRoad(2)
        );
    }
}
