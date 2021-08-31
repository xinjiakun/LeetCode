package com.xin.dp.maxProfit;

/**
 * @author xinjiakun
 * @title: MaxProfit_121
 * @projectName coding
 * @description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *                 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *                 注意你不能在买入股票前卖出股票。
 * @date 2019/11/5 10:27
 */
public class MaxProfit_121 {
    public int maxProfit(int[] prices) {
        int num_0 = 0, num_1 = Integer.MIN_VALUE; //num_0 表示当前不持有股票的利润  num_1表示当前持有股票的利润
        for (int i = 0; i < prices.length; i++) {//i表示天数
            num_0 = num_1 + prices[i] > num_0 ? num_1 + prices[i] : num_0;
            num_1 = num_1 > -prices[i] ? num_1 : 0 - prices[i];
        }
        return num_0;
    }
}
