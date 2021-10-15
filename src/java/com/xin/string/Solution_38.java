package com.xin.string;

/**
 * @Classname Solution_38
 * @Description 外观数列
 * @Date 2021/10/15 14:20
 * @Created by xinjiakun
 */
public class Solution_38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String string = countAndSay(n - 1);
        int num = 0;
        char number = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char s : string.toCharArray()) {
            if (s == number) {
                num++;
            } else {
                if (num != 0) {
                    stringBuilder.append(num);
                    stringBuilder.append(number);
                }
                num = 1;
                number = s;
            }
        }
        stringBuilder.append(num);
        stringBuilder.append(number);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_38().countAndSay(8));
    }
}
