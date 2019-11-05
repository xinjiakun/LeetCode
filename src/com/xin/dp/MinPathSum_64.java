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


}
