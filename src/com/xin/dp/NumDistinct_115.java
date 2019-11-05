package com.xin.dp;

/**
 * @author xinjiakun
 * @title: NumDistinct_115
 * @projectName coding
 * @description: 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *                 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余
 *                 字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *                 动态规划
 *
 *                  dp[i][j] 代表 T 前 i 字符串可以由 S j 字符串组成最多个数.
 *                  所以动态方程:
 *                  当 S[j] == T[i] , dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
 *                  当 S[j] != T[i] , dp[i][j] = dp[i][j-1]
 * @date 2019/11/4 9:45
 */
public class NumDistinct_115 {
    public int numDistinct(String s, String t) {
        int des[][] = new int[t.length()+1][s.length()+1];
        for (int i = 0; i < s.length()+1; i++) {
            des[0][i] = 1;
        }
        for (int i = 1; i < t.length()+1; i++) {
            des[i][0] = 0;
        }
        for (int i = 1; i < t.length()+1; i++) {
            for (int m = 1; m < s.length()+1; m++) {
                if (t.charAt(i-1) == s.charAt(m-1)) {
                    des[i][m] = des[i - 1][m - 1] + des[i][m - 1];
                } else {
                    des[i][m] = des[i][m - 1];
                }
            }
        }
        return des[t.length()][s.length()];
    }

    public static void main(String[] args) {
        NumDistinct_115 numDistinct = new NumDistinct_115();
        System.out.println(numDistinct.numDistinct("rabbbit","rabbit"));
    }
}

