package com.xin.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 辛佳锟
 * @title: Solution_282
 * @projectName LeetCode
 * @description: TODO
 * @date 2021/10/16 16:00
 */
public class Solution_282 {
    int n;
    List<String> strings;
    String num;
    int target;

    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.strings = new ArrayList<>();
        this.target = target;
        StringBuffer stringBuffer = new StringBuffer();
        backtrack(stringBuffer, 0, 0, 0);
        return strings;
    }

    void backtrack(StringBuffer sb, int i, long req, long end) {
        if (i == n) {
            if (req == target) {
                strings.add(sb.toString());
            }
            return;
        }
        int index = sb.length();
        long value = 0;
        if (i > 0) {
            sb.append(0);
        }
        for (int a = i; a < n && (a == i || num.charAt(i) != '0'); ++a) {
            value = value * 10 + num.charAt(a) - '0';
            sb.append(num.charAt(a));
            if (i == 0) {
                backtrack(sb, a + 1, value, value);
            } else {
                sb.setCharAt(index, '+');
                backtrack(sb, a + 1, req + value, value);
                sb.setCharAt(index, '-');
                backtrack(sb, a + 1, req - value, -value);
                sb.setCharAt(index, '*');
                backtrack(sb, a + 1, req - end + end * value, end * value);
            }
        }
        sb.setLength(index);
    }
}
