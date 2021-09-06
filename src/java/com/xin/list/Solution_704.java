package com.xin.list;

/**
 * @Classname Solution_704
 * @Description 二分查找
 * @Date 2021/9/6 12:19
 * @Created by xinjiakun
 */
public class Solution_704 {
    public int search(int[] nums, int target) {
        int i = 0;
        int start = 0;
        int end = nums.length ;
        while (start < end && i >= 0 && i < nums.length) {
            i = (start + end) / 2;
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                if (end == i) {
                    break;
                }
                end = i;
            } else {
                if (start == i) {
                    break;
                }
                start = i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5};
        System.out.println(new Solution_704().search(a, 5));
    }
}
