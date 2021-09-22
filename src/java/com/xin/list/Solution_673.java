package com.xin.list;

/**
 * @Classname Solution_673
 * @Description 最长递增子序列的个数
 * @Date 2021/9/20 21:00
 * @Created by xinjiakun
 */
public class Solution_673 {
    public int findNumberOfLIS(int[] nums) {
        int num = 0;
        int last=0;
        int max = 0;
        for (int a = 0; a < nums.length; a++) {
            int length = 0;
            for (int b = a; b < nums.length; b++) {
                if (nums[b] > max) {
                    max = nums[b];
                    length++;
                }
            }
            if (length>last){
                last=length;
            }
        }
        return num;
    }

}
