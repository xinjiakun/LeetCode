package com.xin.math;

/**
 * @Classname Solution_367
 * @Description 有效的完全平方数
 * @Date 2021/11/4 17:34
 * @Created by xinjiakun
 */
public class Solution_367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long left = 0;
        long right = num;
        while (left < right) {
            long mid = (left + right) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid;
            } else {
                left = mid;
            }
            if (left + 1 == right) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i=1;i<100;i++){
            System.out.println(new Solution_367().isPerfectSquare(2147483647));
        }
    }
}
