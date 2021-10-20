package com.xin.list;

import java.util.Arrays;

/**
 * @Classname Solution_453
 * @Description 最小操作次数使数组元素相等
 * @Date 2021/10/20 18:40
 * @Created by xinjiakun
 */
public class Solution_453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        int length = nums.length;
        int a = 0;
        for (int i = length - 1; i >= 0; i--) {
            int l = 0;
            if (i != length - 1) {
                l = i + 1;
            }
            num += nums[i] - nums[l] + a;
            a = nums[i] - nums[l] + a;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        new Solution_453().minMoves(a);
    }
}
