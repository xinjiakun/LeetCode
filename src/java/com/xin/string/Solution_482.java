package com.xin.string;

/**
 * @Classname Solution_482
 * @Description 密钥格式化
 * @Date 2021/10/5 17:23
 * @Created by xinjiakun
 */
public class Solution_482 {
    public String licenseKeyFormatting(String s, int k) {
        int num = 0;
        StringBuilder end = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                if (num % k == 0 && num != 0) {
                    end.append("-");
                }
                num++;
                char a = s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ? (char) (s.charAt(i) - 32) : s.charAt(i);
                end.append(a);
            }
        }
        return end.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_482().licenseKeyFormatting("aaaa", 2));
    }
}
