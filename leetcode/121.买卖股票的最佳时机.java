/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润
     * <p>
     * 注意：你不能在买入股票前卖出股票
     * <p>
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0, buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int sale = prices[i];
            if (buy < sale) {
                max = Math.max(max, sale - buy);
            } else if (buy > sale) {
                buy = sale;
            }
        }
        return max;
    }
}
// @lc code=end

