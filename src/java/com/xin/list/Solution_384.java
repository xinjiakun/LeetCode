package com.xin.list;

import java.util.Arrays;
import java.util.Random;

/**
 * @Classname Solution_384
 * @Description 打乱数组
 * @Date 2021/11/22 12:40
 * @Created by xinjiakun
 */
public class Solution_384 {
    int[] init;
    int[] newData;


    public Solution_384(int[] nums) {
        init = Arrays.copyOf(nums, nums.length);
        newData = nums;
    }

    public int[] reset() {
        newData = Arrays.copyOf(init, init.length);
        return newData;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < newData.length; i++) {
            int j = i + random.nextInt(newData.length - i);
            int data = newData[j];
            newData[j] = newData[i];
            newData[i] = data;
        }
        return newData;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        Solution_384 a = new Solution_384(data);
        System.out.println(a.shuffle());
        System.out.println(a.reset());
        System.out.println(a.shuffle());
    }
}
