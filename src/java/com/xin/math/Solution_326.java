package com.xin.math;

/**
 * @Classname Solution_326
 * @Description 3的幂
 * @Date 2021/9/23 20:53
 * @Created by xinjiakun
 */
public class Solution_326 {
    public boolean isPowerOfThree(int n) {
        if (n < 3 && n != 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        new Solution_326().isPowerOfThree(27);
    }
}
