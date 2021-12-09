package org.luvx.leetcode.java.medium._1262;

// @lc code=start
/*
 * @lc app=leetcode.cn id=1262 lang=java
 *
 * [1262] 可被三整除的最大和
 */
class Solution {
    /**
     * 3,6,5,1,8 -> 3 6 1 8 -> 18
     * 1,2,3,4,4 -> 1 3 4 4 -> 12
     * 2,3,4,4,4 -> 3 4 4 4 -> 15
     * 2,3,4,5 -> 3 4 5 -> 12
     */
    public int maxSumDivThree(int[] nums) {
        final int N = 3;
        int[] dp = new int[] {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] dp2 = new int[N];
            for (int i = 0; i < N; i++) {
                int index = (i + num) % N;
                dp2[index] = Math.max(dp[index], dp[i] + num);
            }
            dp = dp2;
        }
        return dp[0];
    }

    public int maxSumDivThree1(int[] nums) {
        final int T = 3;
        // 记录下最小的导致sum不能整除的元素的和
        int sum = 0, oneRemainder = 20_000, twoRemainder = 20_000;
        for (int num : nums) {
            sum += num;
            if (num % T == 1) {
                twoRemainder = Math.min(twoRemainder, oneRemainder + num);
                oneRemainder = Math.min(oneRemainder, num);
            } else if (num % T == 2) {
                oneRemainder = Math.min(oneRemainder, twoRemainder + num);
                twoRemainder = Math.min(twoRemainder, num);
            }
        }

        if (sum % T == 0) {
            return sum;
        }
        return sum % T == 1 ? sum - oneRemainder : sum - twoRemainder;
    }
}
// @lc code=end

