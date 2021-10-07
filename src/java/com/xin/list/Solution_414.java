package com.xin.list;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @Classname Solution_414
 * @Description 第三大的数
 * @Date 2021/10/6 11:26
 * @Created by xinjiakun
 */
public class Solution_414 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }
}
