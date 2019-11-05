package com.xin.dp.rob;

/**
 * @author xinjiakun
 * @title: Rob_198
 * @projectName coding
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 *                 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
                    状态量 1 房子数 2 每一个房子的状态(是否被盗 0为未盗 1为已盗)
                    状态方程为  dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
                                dp[i][1] = dp[i - 1][0] + nums[i];
 * @date 2019/11/5 15:53
 */
public class Rob_198 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int dp[][] = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {//base case
                dp[i][0] = 0;
                dp[i][1] = nums[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + nums[i];
            }

        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
