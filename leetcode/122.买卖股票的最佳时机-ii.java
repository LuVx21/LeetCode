/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        //<editor-fold desc="方式1">
        /*int sum = 0, buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int sale = prices[i];
            if (buy < sale) {
                if (i + 1 < prices.length) {
                    if (sale <= prices[i + 1]) {
                        continue;
                    } else {
                        sum += sale - buy;
                        buy = prices[i + 1];
                    }
                } else {
                    sum += sale - buy;
                }
            } else if (buy > sale) {
                buy = sale;
            }
        }*/
        //</editor-fold>

        //<editor-fold desc="方式2">
        int sum = 0;
        for (int i = 0; i < prices.length; ) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int min = prices[i++];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            sum += i < prices.length ? prices[i++] - min : 0;
        }
        //</editor-fold>

        return sum;
    }
}
// @lc code=end

