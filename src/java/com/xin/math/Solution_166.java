package com.xin.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution_166
 * @Description 分数到小数
 * @Date 2021/10/5 17:53
 * @Created by xinjiakun
 */
public class Solution_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }
        StringBuilder string = new StringBuilder();
        if (numeratorLong < 0 ^ denominatorLong < 0) {
            string.append("-");
        }
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        string.append(numeratorLong / denominatorLong);
        string.append(".");
        long x = numeratorLong % denominatorLong;
        Map<Long, Integer> map = new HashMap<>();
        int index = 0;
        StringBuilder f = new StringBuilder();
        while (x != 0 && !map.containsKey(x)) {
            map.put(x, index++);
            x *= 10;
            f.append(x / denominatorLong);
            x %= denominatorLong;
        }
        if (x != 0) {
            f.insert(map.get(x), "(");
            f.append(")");
        }
        return string.append(f).toString();
    }
}
