package com.xin.list;

import java.util.Arrays;

/**
 * @author 辛佳锟
 * @title: Solution_260
 * @projectName LeetCode
 * @description: 只出现一次的数字 III
 * @date 2021/10/30 16:41
 */
public class Solution_260 {
    public int[] singleNumber(int[] nums) {
        int[] value = new int[2];
        int index = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (index == 2) {
                return value;
            }
            if ((i == 0 && nums[i] != nums[i + 1]) || (i == nums.length - 1 && nums[i - 1] != nums[i]) ||
                    (i > 0 && i < nums.length - 1 && nums[i] != nums[i + 1] && nums[i - 1] != nums[i])
            ) {
                value[index++] = nums[i];
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1,3,2,5};
        new Solution_260().singleNumber(a);
    }
}
