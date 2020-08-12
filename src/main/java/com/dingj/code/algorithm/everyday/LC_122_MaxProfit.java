package com.dingj.code.algorithm.everyday;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LC_122_MaxProfit {

    /**
     * 贪心算法，只要上涨就卖，跌不卖
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }

        return profit;

    }
}
