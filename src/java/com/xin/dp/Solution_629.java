package com.xin.dp;

/**
 * @author 辛佳锟
 * @title: Solution_629
 * @projectName LeetCode
 * @description: K个逆序对数组
 * @date 2021/11/13 21:09
 */
public class Solution_629 {
    static final int mod = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - (j >= i ? dp[i - 1][j - i] : 0);
                if (dp[i][j] < 0) {
                    dp[i][j] += mod;
                }
                dp[i][j] = dp[i][j] % mod;
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_629().kInversePairs(3, 1));
    }
}
