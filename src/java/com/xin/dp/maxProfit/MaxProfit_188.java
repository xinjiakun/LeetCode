package com.xin.dp.maxProfit;

/**
 * @author xinjiakun
 * @title: MaxProfit_123
 * @projectName coding
 * @description: 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *                 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * @date 2019/11/4 15:02
 */
public class MaxProfit_188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;//空数组直接返回0
        }
        if (k > prices.length / 2) {
            return helper(prices);//k值太大出现超内存的错误，一次交易由买入和卖出构成，至少需要两天。有效的限制 k 应该不超过 n/2，超过就没有约束作用了，相当于 k = +infinity
        }
        int dp[][][] = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int m = 1; m < k + 1; m++) {
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
        return dp[prices.length - 1][k][0];
    }

    public int helper(int[] prices) {
        int num_0 = 0, num_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = num_0;
            num_0 = num_1 + prices[i] > num_0 ? num_1 + prices[i] : num_0;
            num_1 = num_1 > temp - prices[i] ? num_1 : temp - prices[i];
        }
        return num_0;
    }
}
