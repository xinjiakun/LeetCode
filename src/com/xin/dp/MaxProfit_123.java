package com.xin.dp;

/**
 * @author xinjiakun
 * @title: MaxProfit_123
 * @projectName coding
 * @description: TODO
 * @date 2019/11/4 15:02
 */
public class MaxProfit_123 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int arr[][] = new int[prices.length][prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            for (int m = i + 1; m < prices.length; m++) {
                arr[i][m] = prices[m] - prices[i];
            }
        }

    }
}
