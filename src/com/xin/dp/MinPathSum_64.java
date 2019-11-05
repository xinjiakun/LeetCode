package com.xin.dp;
/**
 * 
    * @ClassName: MinPathSum_64
    * @Description: TODO  给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 * 							角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 * 							加起来。返回最小的路径和。
    * @author xinjiakun
    *
 */
public class MinPathSum_64 {
	public static int dpMinPath(int[][]matric) {
		int row = matric.length - 1;
		int col = matric[0].length - 1;
		int [][]dp = new int[row+1][col+1];
		dp[row][col] = matric[row][col];
		//最后一行
		for(int i = col -1;i >= 0;i--) {
			dp[row][i] = dp[row][i+1] + matric[row][i];
		}
		//最后一列
		for(int i = row -1;i >= 0;i--) {
			dp[i][col] = dp[i+1][col] + matric[i][col];
		}
		//普通情况
		for(int i = row -1;i >= 0;i--) {
			for(int n = col -1;n >= 0;n--) {
				dp[i][n] = (dp[i+1][n] > dp[i][n+1] ? dp[i][n+1] : dp[i+1][n]) + matric[i][n];
			}
		}
		print(dp);
		return dp[0][0];
	}
	public static void main(String[] args) {
		int [][] text = {
				{3,2,1},
				{1,0,0},
				{3,5,4}
		};
		int [][] text2 = {
				{ 1, 3, 5, 9 },
				{ 8, 1, 3, 4 }, 
				{ 5, 0, 6, 1 }, 
				{ 8, 8, 4, 0 }
		};
		System.out.println(dpMinPath(text));
		System.out.println();
		System.out.println(dpMinPath(text2));
		
	}
	public static void print(int[][]a) {
		for(int [] is : a) {
			for(int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	/**
	 * @author xinjiakun
	 * @title: Rob_213
	 * @projectName coding
	 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
	 *                 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
						状态量 1 房子数 2 每一个房子的状态(是否被盗 0为未盗 1为已盗)
						状态方程为  dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
									dp[i][1] = dp[i - 1][0] + nums[i];
						分两种情况为nums[0:n-1]  nums[1:n]
	 * @date 2019/11/5 15:53
	 */
	public static class Rob_213 {
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
}
