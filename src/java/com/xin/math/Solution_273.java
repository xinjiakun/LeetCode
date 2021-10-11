package com.xin.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution_273
 * @Description 整数转换英文表示
 * @Date 2021/10/11 17:47
 * @Created by xinjiakun
 */
public class Solution_273 {
    String[] number = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] numberTen = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return number[0];
        }
        List<String> stringList = new ArrayList<>(4);
        while (num >= 1000) {
            num = get(num, stringList);
        }
        get(num, stringList);
        StringBuffer ss = new StringBuffer();
        for (int i = 0; i < stringList.size(); i++) {
            String q = stringList.get(i);
            if (i > 0 && !q.equals(" ")) {
                ss.insert(0, numberTen[10 + i] + " ");
            }
            if (!q.equals(" ")) {
                ss.insert(0, q.trim() + " ");
            }

        }
        return ss.toString().trim();
    }

    int get(int num, List<String> stringList) {
        String b = " ";
        int a = num % 1000;
        num /= 1000;
        int s1 = a / 100;
        int s2 = a % 100;
        if (s1 > 0) {
            b += number[s1] + " " + numberTen[10] + " ";
        }
        if (s2 < 20) {
            if (s2 > 0) {
                b += number[s2] + " ";

            }
        } else {
            int d = s2 / 10;
            b += numberTen[d] + " ";
            if (s2 % 10 != 0) {
                b += number[s2 % 10] + " ";
            }
        }
        stringList.add(b);
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_273().numberToWords(12345));
    }
}
