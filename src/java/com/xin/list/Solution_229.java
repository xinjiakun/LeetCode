package com.xin.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname Solution_229
 * @Description 求众数 II
 * @Date 2021/10/22 16:53
 * @Created by xinjiakun
 */
public class Solution_229 {
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
            map.put(Integer.valueOf(nums[i]), num + 1);
        }
        map.entrySet().forEach(item -> {
            if (item.getValue() > length) {
                list.add(item.getKey());
            }
        });
        return list;
    }
}
