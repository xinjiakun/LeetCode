package com.xin.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution_447
 * @Description 回旋镖的数量
 * @Date 2021/9/13 20:38
 * @Created by xinjiakun
 */
public class Solution_447 {
    public int numberOfBoomerangs(int[][] points) {
        int num = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n = 0; n < points.length; n++) {
                Integer key = (points[i][0] - points[n][0]) * (points[i][0] - points[n][0]) + (points[i][1] - points[n][1]) * (points[i][1] - points[n][1]);
                Integer value = map.get(key);
                map.put(key, value == null ? 1 : ++value);
            }
            for (Integer v : map.values()) {
                num += v * (v - 1);
            }
        }
        return num;
    }

}
