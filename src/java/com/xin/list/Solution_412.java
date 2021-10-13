package com.xin.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution_412
 * @Description Fizz Buzz
 * @Date 2021/10/13 18:36
 * @Created by xinjiakun
 */
public class Solution_412 {
    public List<String> fizzBuzz(int n) {
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    stringList.add("FizzBuzz");
                    continue;
                }
                stringList.add("Fizz");
                continue;
            } else if (i % 5 == 0) {
                stringList.add("Buzz");
                continue;
            }
            stringList.add(String.valueOf(i));
        }
        return stringList;
    }
}
