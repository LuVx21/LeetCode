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
        // 第一层数组元素含义: 0: 前一问题的结果, 1: 当前问题计算出的结果
        // 第二层数组元素含义: 0: 模3=0, 1: 模3=2, 2: 模3=1 的和
        var array = new int[2][3];
        array[0][1] = array[0][2] = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // dp0: i-1时(上次)的最大和, dp: i时(本次)的最大和
            int[] dp0 = array[i % 2], dp = array[(i + 1) % 2];
            // 分三种场景(即当前问题的计算必须依赖以下三个子问题其中一个,虽然是其中之一,但其他两种的最大和也需要求出):
            // num整除3, 此时num必须加入最大和
            // num模3余1, 要么num不加入,要么num加入,同时找模3余2的最大和, 两种取max
            // num模3余2, 要么num不加入,要么num加入,同时找模3余1的最大和, 两种取max
            for (int j = 0; j < N; j++) {
                // j 的循环是为了分别计算 模3余?的最大和
                int index = (j + num) % N;
                // max(不加入(即上次), 匹配+加入)
                int join = dp0[index] + num;
                dp[j] = Math.max(dp0[j], join);
            }
        }
        return array[nums.length % 2][0];
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

