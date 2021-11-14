package com.xin.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 辛佳锟
 * @title: Solution_677
 * @projectName LeetCode
 * @description: 键值映射
 * @date 2021/11/14 15:31
 */
public class Solution_677 {
    TrieNode root;
    Map<String, Integer> map = new HashMap<>();

    class TrieNode {
        int val;
        TrieNode[] node = new TrieNode[26];

        TrieNode() {

        }
    }

    public Solution_677() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        int aa = map.containsKey(key) ? val - map.get(key) : val;
        map.put(key, val);
        TrieNode a = root;
        for (char c : key.toCharArray()) {
            if (a.node[c - 'a'] == null) {
                a.node[c - 'a'] = new TrieNode();
            }
            a = a.node[c - 'a'];
            a.val += aa;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        int num = 0;
        for (char a : prefix.toCharArray()) {
            if (node.node[a - 'a'] == null) {
                return 0;
            }
            node = node.node[a - 'a'];
            num = node.val;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution_677 solution_677 = new Solution_677();
        solution_677.insert("a", 3);
        solution_677.sum("ap");
        solution_677.insert("b", 2);
        System.out.println(solution_677.sum("a"));
    }
}
