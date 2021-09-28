package com.xin.dp;

/**
 * @Classname Solution_639
 * @Description 解码方法 II
 * @Date 2021/9/27 20:34
 * @Created by xinjiakun
 */
public class Solution_639 {
    static final int MOD = 1000000007;

    public int numDecodings(String s) {


        if (s == " ") {
            return 1;
        }
        long[] data = new long[s.length()];
        data[0] = s.charAt(0) == '*' ? 9 : 1;
        if (s.charAt(0) == '0') {
            data[0] = 0;
        }
        for (int i = 1; i < s.length(); i++) {
            long a = i == 1 ? 1 : data[i - 2];
            long b = s.charAt(i) == '*' ? (data[i - 1] * 9) : data[i - 1];
            if (s.charAt(i) == '0') {
                b = 0;
            }
            if (s.charAt(i - 1) == '*') {
                if (s.charAt(i) == '*') {
                    a *= 15;
                } else if (s.charAt(i) >= '0' && s.charAt(i) <= '6') {
                    a *= 2;
                }
            } else if (s.charAt(i - 1) == '1') {
                if (s.charAt(i) == '*') {
                    a *= 9;
                }
            } else if (s.charAt(i - 1) == '2') {
                if (s.charAt(i) == '*') {
                    a *= 6;
                } else if (s.charAt(i) >= '7' && s.charAt(i) <= '9') {
                    a = 0;
                }
            } else {
                a = 0;
            }
            data[i] = (a + b) % MOD;
        }
        return (int) data[s.length() - 1] % MOD;
    }


    public static void main(String[] args) {
        System.out.println(new Solution_639().numDecodings("7*9*3*6*3*0*5*4*9*7*"));
    }
}
