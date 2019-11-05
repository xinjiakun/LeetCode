package com.xin.dp.rob;

/**
 * @author xinjiakun
 * @title: Rob_213
 * @projectName coding
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 *                  同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
                    状态量 1 房子数 2 每一个房子的状态(是否被盗 0为未盗 1为已盗)
                    状态方程为  dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
                    dp[i][1] = dp[i - 1][0] + nums[i];
                    分两种情况为nums[0:n-1]  nums[1:n]
 * @date 2019/11/5 15:53
 */
public  class Rob_213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int dp[][] = new int[nums.length][2];
        int max = 0;
        //nums[0:n-1]
        for (int i = 0; i < nums.length-1; i++) {
            if (i == 0) {//base case
                dp[i][0] = 0;
                dp[i][1] = nums[i];
            }else  {
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + nums[i];
            }

        }
        max = Math.max(dp[nums.length - 2][0], dp[nums.length - 2][1]);
        //nums[1:n]
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {//base case
                dp[i][0] = 0;
                dp[i][1] = nums[i];
            }else  {
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + nums[i];
            }

        }
        max = Math.max(Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]),max);
        return max;
    }
}
