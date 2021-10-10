package com.xin.math;

/**
 * @author 辛佳锟
 * @title: Solution_441
 * @projectName LeetCode
 * @description: 排列硬币
 * @date 2021/10/10 15:27
 */
public class Solution_441 {
    public int arrangeCoins(int n) {
        int num = 0;
        for (int i = 1; ; i++) {
            n -= i;
            if (n >= 0) {
                num++;
            } else {
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_441().arrangeCoins(1));
    }
}
