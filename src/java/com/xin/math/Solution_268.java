package com.xin.math;

/**
 * @author 辛佳锟
 * @title: Solution_268
 * @projectName LeetCode
 * @description: 丢失的数字
 * @date 2021/11/6 15:20
 */
public class Solution_268 {
    public int missingNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            a += (i + 1);
            b += nums[i];
        }
        return a - b;
    }
}
