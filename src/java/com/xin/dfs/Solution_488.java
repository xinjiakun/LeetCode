package com.xin.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution_488
 * @Description 祖玛游戏
 * @Date 2021/11/9 20:23
 * @Created by xinjiakun
 */
public class Solution_488 {
    Integer num = Integer.MAX_VALUE;
    Map<String, Boolean> v = new HashMap<>();

    public int findMinStep(String board, String hand) {
        Map<Character, Integer> handMap = new HashMap<>(5);
        for (int i = 0; i < hand.length(); i++) {
            handMap.put(hand.charAt(i), handMap.getOrDefault(hand.charAt(i), 0) + 1);
        }
        dfs(board, 0, handMap);
        num = num == Integer.MAX_VALUE ? -1 : num;
        v = new HashMap<>();
        return num;
    }

    void dfs(String board, int count, Map<Character, Integer> handMap) {

        if (board.length() == 0) {
            num = Math.min(count, num);
            return;
        }
        if (handMap.isEmpty()) {
            return;
        }
        if (v.get(board) != null) {
            return;
        }
        v.put(board, true);
        for (Character character : handMap.keySet()) {
            if (handMap.get(character) == 0) {
                continue;
            }
            for (int i = 0; i < board.length(); i++) {
                handMap.put(character, handMap.get(character) - 1);
                dfs(eliminate(board.substring(0, i + 1) + character.toString() + board.substring(i + 1)), count + 1, handMap);
                handMap.put(character, handMap.get(character) + 1);
            }
        }
    }

    String eliminate(String s) {
        boolean a = true;
        while (a) {
            a = false;
            for (int i = 0, j = 0; i < s.length(); j = i) {
                while (i < s.length() && s.charAt(i) == s.charAt(j)) {
                    i++;
                }
                if (i - j >= 3) {
                    s = s.substring(0, j) + s.substring(i);
                    a = true;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println("WRRBBW".substring(0, 1));
        System.out.println(new Solution_488().findMinStep("WRRBBW","RB"));
        System.out.println(new Solution_488().eliminate("abaaabb"));
    }
}
