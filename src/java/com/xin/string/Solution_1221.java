package com.xin.string;

/**
 * @Classname Solution_1221
 * @Description 对称字符串
 * @Date 2021/9/7 9:21
 * @Created by xinjiakun
 */
public class Solution_1221 {
    public int balancedStringSplit(String s) {
        char left = 0;
        char right = 0;
        int num = 0;
        for (char a : s.toCharArray()) {
            if (a == 'L') {
                left++;
            }
            if (a == 'R') {
                right++;
            }
            if (left == right && left != 0) {
                left = 0;
                right = 0;
                num++;
            }
        }
        return num;
    }
}
