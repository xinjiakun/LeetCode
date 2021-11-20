package com.xin.list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 辛佳锟
 * @title: Solution_594
 * @projectName LeetCode
 * @description: 最长和谐子序列
 * @date 2021/11/20 17:54
 */
public class Solution_594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        Set<Integer>set  = map.keySet();
        for (Integer key:set) {
            if (map.containsKey(key - 1)) {
                max = Math.max(max, map.get(key) + map.get(key - 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[]a = {1,3,2,2,5,2,3,7};
        System.out.println(new Solution_594().findLHS(a));
    }
}
