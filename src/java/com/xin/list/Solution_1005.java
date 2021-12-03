package com.xin.list;

import java.util.Arrays;

/**
 * @author 辛佳锟
 * @title: Solution_1005
 * @projectName LeetCode
 * @description: K 次取反后最大化的数组和
 * @date 2021/12/3 21:53
 */
public class Solution_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int len=nums.length;
        for (int i = 0; i < k; i++) {
            if (i>len-1){
                if ((k - i) % 2 == 1){
                    nums[len-1] = -nums[len-1];
                }
                break;
            }
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            } else {
                if ((k - i) % 2 == 1) {
                    if (i > 0 && nums[i - 1] < nums[i]) {
                        nums[i - 1] = -nums[i - 1];
                    } else {
                        nums[i] = -nums[i];
                    }
                }
                break;

            }
        }
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a += nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-4,-2,-3};
        System.out.println(new Solution_1005().largestSumAfterKNegations(a, 4));
    }
}
