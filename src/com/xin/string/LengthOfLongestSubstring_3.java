package com.xin.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinjiakun
 * @title: LengthOfLongestSubstring_3
 * @projectName coding
 * @description: TODO
 * @date 2019/11/15 15:02
 */
public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        Map map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            for (int n = i; n < s.length(); n++) {
                if (map.containsKey(s.charAt(n))) {
                    max = Math.max(max, map.size());
                    map.clear();
                    break;
                } else {
                    map.put(s.charAt(n), 1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring_3().lengthOfLongestSubstring("jbpnbwwd"));
    }
}
