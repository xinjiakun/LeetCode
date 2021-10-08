package com.xin.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname Solution_187
 * @Description 重复的DNA序列
 * @Date 2021/10/8 17:19
 * @Created by xinjiakun
 */
public class Solution_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> strings = new ArrayList<>();
        if (s.length() >= 10) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i + 9 < s.length(); i++) {
                String x = s.substring(i, i + 10);
                Integer a = map.get(x);
                map.put(x, a == null ? 1 : ++a);
            }
            for (Map.Entry<String, Integer> item : map.entrySet()) {
                if (item.getValue() > 1) {
                    strings.add(item.getKey());
                }
            }
        }
        return strings;
    }
}
