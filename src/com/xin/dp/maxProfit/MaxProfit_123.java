package com.xin.dp.maxProfit;

/**
 * @author xinjiakun
 * @title: MaxProfit_123
 * @projectName coding
 * @description: 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * @date 2019/11/4 15:02
 */
public class MaxProfit_123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;//数组为空直接返回0
        }
        int dp[][][] = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            for (int m = 1; m < 3; m++) {
                if (i - 1 == -1) {
                    //   dp[i][m][1]
                    // = max(dp[-1][m][1], dp[-1][m][0] - prices[i])
                    // = max(-infinity, 0 - prices[i])
                    // = -prices[i]
                    dp[i][m][1] = -prices[i];
                    //   dp[i][m][0]
                    // = max(dp[-1][m][0], dp[-1][m][1] + prices[i])
                    // = max(0, -infinity + prices[i])
                    // = 0
                    dp[i][m][0] = 0;
                    continue;
                }
                dp[i][m][0] = Math.max(dp[i - 1][m][0], dp[i - 1][m][1] + prices[i]);
                dp[i][m][1] = Math.max(dp[i - 1][m][1], dp[i - 1][m - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][2][0];
    }
}
