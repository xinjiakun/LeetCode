package com.xin.string;

import java.util.*;

/**
 * @author 辛佳锟
 * @title: Solution_438
 * @projectName LeetCode
 * @description: 找到字符串中所有字母异位词
 * @date 2021/11/28 13:41
 */
public class Solution_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> a = new ArrayList<>();
        if (s.length() < p.length()) {
            return a;
        }
        int[] slen = new int[26];
        int[] plen = new int[26];
        int pfrist = 0;
        int plast = 0;
        for (int i = 0; i < p.length(); i++) {
            ++plen[(p.charAt(i) - 'a')];
        }
        for (int i = 0; i < s.length(); i++) {
            ++slen[(s.charAt(i) - 'a')];
            if (plast - pfrist == p.length() - 1) {
                if (listEquals(slen, plen)) {
                    a.add(pfrist);
                }
                --slen[(s.charAt(pfrist) - 'a')];
                pfrist++;
            }
            plast++;
        }
        return a;
    }

    boolean listEquals(int[] l, int[] r) {
        for (int i = 0; i < l.length; i++) {
            if (l[i] != r[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> a = new Solution_438().findAnagrams("aacbebabacd", "bbb");
        a.forEach(item -> {
            System.out.println(item);
        });

    }
}
