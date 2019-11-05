package com.xin.dp.maxProfit;

/**
 * @author xinjiakun
 * @title: MaxProfit_123
 * @projectName coding
 * @description: 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * @date 2019/11/4 15:02
 */
public class MaxProfit_309 {
    public int maxProfit(int[] prices) {
        int num_0 = 0, num_1 = Integer.MIN_VALUE, pre_0 = 0;//pre保存两天前的利润
        for (int i = 0; i < prices.length; i++) {
            int temp = num_0;
            num_0 = num_1 + prices[i] > num_0 ? num_1 + prices[i] : num_0;
            num_1 = num_1 > pre_0 - prices[i] ? num_1 : pre_0 - prices[i];
            pre_0 = temp;
        }
        return num_0;
    }
}
