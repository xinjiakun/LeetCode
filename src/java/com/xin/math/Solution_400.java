package com.xin.math;

/**
 * @author 辛佳锟
 * @title: Solution_400
 * @projectName LeetCode
 * @description: 第 N 位数字
 * @date 2021/11/30 22:16
 */
public class Solution_400 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long num = 9;
        int x = 9;
        int i = 1;
        while (num < n) {
            i++;
            x *= 10;
            num += (long) x * i;
        }
        num -= x * i;
        int z = n - (int) num;
        int q = z / i;
        int a = z % i;
        int w = 1;
        for (int r = 1; r < i; r++) {
            w *= 10;
        }
        w += q;
        if (a == 0) {
            w -= 1;
            return String.valueOf(w).charAt(i - 1) - '0';
        }
        return String.valueOf(w).charAt(a - 1) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new Solution_400().findNthDigit(100));
    }
}
