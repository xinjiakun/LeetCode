package com.xin.string;

/**
 * @Classname Solution_1446
 * @Description 连续字符
 * @Date 2021/12/1 12:41
 * @Created by xinjiakun
 */
public class Solution_1446 {
    public int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int num = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                num = Math.max(num, j - i);
                i = j;
            }
            j++;
        }
        num = Math.max(num, j - i);
        return num;
    }

    public static void main(String[] args) {
        new Solution_1446().maxPower("lee");
    }
}
