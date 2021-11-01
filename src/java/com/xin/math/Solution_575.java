package com.xin.math;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname Solution_575
 * @Description 分糖果
 * @Date 2021/11/1 9:48
 * @Created by xinjiakun
 */
public class Solution_575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> a = new HashSet<>();
        for (int q : candyType) {
            a.add(q);
        }
        int c = candyType.length / 2;
        return a.size() >= c ? c : a.size();
    }
}
