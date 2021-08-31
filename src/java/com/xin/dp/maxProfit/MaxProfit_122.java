package com.xin.dp.maxProfit;

/**
 * @author xinjiakun
 * @title: MaxProfit_121
 * @projectName coding
 * @description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *                设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *                k无限制为无穷大
 * @date 2019/11/5 10:27
 */
public class MaxProfit_122 {
    public int maxProfit(int[] prices) {
        int num_0 = 0, num_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = num_0;
            num_0 = num_1 + prices[i] > num_0 ? num_1 + prices[i] : num_0;
            num_1 = num_1 > temp - prices[i] ? num_1 : temp - prices[i];
        }
        return num_0;
    }
}
