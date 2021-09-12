package com.xin.math;

/**
 * @author 辛佳锟
 * @title: Solution_600
 * @projectName LeetCode
 * @description: 不含连续1的非负整数
 * @date 2021/9/11 10:40
 */
public class Solution_600 {
    public int findIntegers(int n) {
        if (n < 3) {
            return n + 1;
        }
        int num = 0;
        int i = 3;
        while (i < n) {
            num += i / 3;
            i *= 2;
        }
        if (i == n) {
            num++;
        }
        return n + 1 - num;
    }

    public static void main(String[] args) {
        new Solution_600().findIntegers(11);
    }
}
