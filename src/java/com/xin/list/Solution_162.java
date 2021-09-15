package com.xin.list;

/**
 * @author 辛佳锟
 * @title: Solution_162
 * @projectName LeetCode
 * @description: 寻找峰值
 * @date 2021/9/15 21:57
 */
public class Solution_162 {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 1 || nums[0] > nums[1]) {
            return 0;
        } else if (nums[length - 1] > nums[length - 2]) {
            return length - 1;
        }
        return getHighIndex(nums, 1, length - 1);
    }

    public int getHighIndex(int[] nums, int left, int right) {
        int index = (left + right) / 2;
        if (nums[index] > nums[index - 1] && nums[index] > nums[index + 1]) {
            return index;
        }
        if (nums[index] > nums[index - 1]) {
            return getHighIndex(nums, index + 1, right);
        } else {
            return getHighIndex(nums, left, index - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,4,3,2,1};
        new Solution_162().findPeakElement(nums);
    }
}
