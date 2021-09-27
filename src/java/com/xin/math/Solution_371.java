package com.xin.math;

/**
 * @Classname Solution_371
 * @Description 两整数之和
 * @Date 2021/9/26 17:35
 * @Created by xinjiakun
 */
public class Solution_371 {
    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            int a1 = sum;
            int a2 = carry;
            sum = a1 ^ a2;
            carry = (a1 & a2) << 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_371().getSum(0, 1));
    }
}
