package com.xin.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution_299
 * @Description 猜数字游戏
 * @Date 2021/11/8 19:00
 * @Created by xinjiakun
 */
public class Solution_299 {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int[] s = new int[10];
        int[] g = new int[10];
        int a = 0;
        int b = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                ++s[secret.charAt(i) - '0'];
                ++g[guess.charAt(i) - '0'];
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(s[i], g[i]);
        }
        return a + "A" + b + "B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution_299().getHint("1", "1"));
    }
}
