package com.xin.math;

/**
 * @author 辛佳锟
 * @title: Solution_372
 * @projectName LeetCode
 * @description: 超级次方
 * @date 2021/12/5 14:17
 */
public class Solution_372 {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        long sum = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            sum = sum * pow(a, b[i]) % MOD;
            a = pow(a, 10);
        }
        return (int) sum;
    }

    int pow(int x, int y) {
        long sum = 1;
        while (y != 0) {
            if ((y & 1) == 1) {
                sum = sum * x % MOD;
            }
            x = (int)((long)x * x % MOD);
            y = y >> 1;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        int[]a =new int[]{2,0,0};
        System.out.println(new Solution_372().superPow(2147483647,a));
    }
}
