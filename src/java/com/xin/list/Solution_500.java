package com.xin.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 辛佳锟
 * @title: Solution_500
 * @projectName LeetCode
 * @description: 键盘行
 * @date 2021/10/31 14:22
 */
public class Solution_500 {
    public String[] findWords(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        String a = "qwertyuiop";
        String b = "asdfghjkl";
        String c = "zxcvbnm";
        for (char a1 : a.toCharArray()) {
            map.put(String.valueOf(a1), 1);
        }
        for (char a1 : b.toCharArray()) {
            map.put(String.valueOf(a1), 2);
        }
        for (char a1 : c.toCharArray()) {
            map.put(String.valueOf(a1), 3);
        }
        String[] q = new String[words.length];
        int z = 0;
        for (String s : words) {
            if (s.length() == 0) {
                break;
            }
            char w = (char) (s.charAt(0) >= 65 && s.charAt(0) <= 90 ? s.charAt(0) + 'a' - 'A' : s.charAt(0));
            int i = map.get(String.valueOf((char) (s.charAt(0) >= 65 && s.charAt(0) <= 90 ? s.charAt(0) + 'a' - 'A' : s.charAt(0))));
            for (int a1 = 0; a1 < s.length(); a1++) {
                if (map.get(String.valueOf((char) (s.charAt(a1) >= 65 && s.charAt(a1) <= 90 ? s.charAt(a1) + 'a' - 'A' : s.charAt(a1)))) != i) {
                    break;
                }
                if (a1 == s.length() - 1) {
                    q[z++] = s;
                }
            }
        }
        return Arrays.copyOf(q,z);
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String []qq =new Solution_500().findWords(words);
        System.out.println();
    }
}