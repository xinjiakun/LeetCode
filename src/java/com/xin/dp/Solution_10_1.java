package com.xin.dp;

/**
 * @author 辛佳锟
 * @title: Solution_10_1
 * @projectName LeetCode
 * @description: 斐波那契数列
 * @date 2021/9/4 18:25
 */
public class Solution_10_1 {
    public int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int num1 = 1;
        int num2 = 0;
        for (int i = 2; i <= n; i++) {
            int a = num1;
            num1 = (num2+ num1) % 1000000007;

            num2 = a;
        }
        return num1 ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_10_1().fib(3));
    }
}
