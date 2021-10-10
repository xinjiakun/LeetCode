package com.xin.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 辛佳锟
 * @title: Solution_1436
 * @projectName LeetCode
 * @description: 旅行终点站
 * @date 2021/10/1 23:31
 */
public class Solution_1436 {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap(16);
        for (List<String> words : paths) {
            map.put(words.get(0), " ");
        }
        for (List<String> words : paths) {
            if (map.get(words.get(1)) == null) {
                return words.get(1);
            }
        }
        return " ";
    }
}
