package com.xin.math;

/**
 * @author 辛佳锟
 * @title: Solution_476
 * @projectName LeetCode
 * @description: 数字的补数
 * @date 2021/10/18 22:21
 */
public class Solution_476 {
    public int findComplement(int num) {
        int x = 0;
        for (int i = 1; i < 31; i++) {
            if (num >= 1 << i) {
                x = i;
            } else {
                break;
            }
        }
        return num ^ (x != 30 ? (1 << x + 1) - 1 : Integer.MAX_VALUE);
    }
}
