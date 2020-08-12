package com.dingj.code.algorithm.everyday;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 */
public class LC_121_MaxProfit {

    public int maxProfit(int[] prices) {

        int temp = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    continue;
                }
                if (prices[i] - prices[i] > temp) {
                    temp = prices[j] - prices[i];
                }
            }
        }

        return temp;

    }
}
