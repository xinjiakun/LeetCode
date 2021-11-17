package com.xin.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution_318
 * @Description 最大单词长度乘积
 * @Date 2021/11/17 22:00
 * @Created by xinjiakun
 */
public class Solution_318 {
    public int maxProduct(String[] words) {
        int[] data = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int x = 0;
            for (int j = 0; j < words[i].length(); j++) {
                x |= (1 << (words[i].charAt(j)-'a'));
            }
            data[i]=x;
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((data[i] & data[j]) > 0) {
                    continue;
                } else {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[]a= {"a","aa","aaa","aaaa"};
        new Solution_318().maxProduct(a);
    }
}
