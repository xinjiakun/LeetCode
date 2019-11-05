package com.xin.dp.maxProfit;

/**
 * @author xinjiakun
 * @title: MaxProfit_121
 * @projectName coding
 * @description: 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。买卖需要一次手续费

 * @date 2019/11/5 10:27
 */
public class MaxProfit_714 {
    public int maxProfit(int[] prices, int fee) {
        int num_0 = 0, num_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = num_0;
            num_0 = Math.max(num_1 + prices[i],num_0);
            num_1 = Math.max(num_1,temp - prices[i] - fee);//买卖利润-fee(手续费)=最后利润
        }
        return num_0;
    }
}
