package com.xin.dp;
/**
 * 
    * @ClassName: LCS_1143
    * @Description: TODO    最长公共子序列
    * @author xinjiakun
    *
 */
public class LCS_1143 {
	public static void comSubstring(String left ,String right){
			char[] str1 = left.toCharArray();
			char[] str2 = right.toCharArray();
			int[][] c = new int[left.length()+1][right.length()+1];
			int[][] b = new int[left.length()+1][right.length()+1];
			for(int n = 0; n <= left.length(); n++) {
				c[n][0] = 0;
			}
			for(int n = 0; n <= right.length(); n++) {
				c[0][n] = 0;
			}
			for(int n = 1; n <= left.length(); n++) {
				for(int m = 1; m <= right.length(); m++) {
					if(str1[n-1] == str2[m-1]) {
						b[n][m] = 0;
						c[n][m] = c[n-1][m-1] + 1;
					}else if (c[n-1][m] > c[n][m-1]) {
						b[n][m] = 1;
						c[n][m] = c[n-1][m];
					}else {
						b[n][m] = -1;
						c[n][m] = c[n][m-1];
					}
				}
				print(c);
				System.out.println();
			}
			printLcs(b,str1,left.length(),right.length());
	}
	public static void printLcs(int[][] b,char[] str ,int left ,int right) {
		if(left == 0 || right == 0) {
			return;
		}
		if(b[left][right] == 0) {
			printLcs(b, str, left-1, right-1);
			System.out.print(str[left-1]);
		}else if (b[left][right] == 1) {
			printLcs(b, str, left-1, right);
		}else {
			printLcs(b, str, left, right-1);
		}
	}
	public static void print(int[][] a) {
		for(int[] row : a) {
			for(int col : row) {
				System.out.print(col + "");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		String a = "abcdefjh";
		String b = "bqywajrk";
		comSubstring(a,b);
	}
}
