package com.xin.dfs;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname Solution_212
 * @Description 单词搜索 II
 * @Date 2021/9/16 21:13
 * @Created by xinjiakun
 */
public class Solution_212 {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> req = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                dfs(board, i, k, trie, req);
            }
        }
        return new ArrayList<>(req);
    }

    void dfs(char[][] board, int row, int column, Trie trie, Set<String> req) {
        if (trie.childrenNode[board[row][column]-'a']==null){
            return;
        }
        char ch = board[row][column];
        trie = trie.childrenNode[board[row][column]-'a'];
        if (!trie.end) {
            req.add(trie.word);
        }

        board[row][column] = '#';
        for (int[] dir : dirs) {
            int i2 = row + dir[0], j2 = column + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                dfs(board,i2, j2,trie,req);
            }
        }
        board[row][column] = ch;

    }

    public class Trie {
        private Trie[] childrenNode;
        private String word;
        private Boolean end;

        public Trie() {
            this.childrenNode = new Trie[26];
            this.end = false;
        }

        public void insert(String word) {
            Trie trie = this;
            for (char a : word.toCharArray()) {
                if (trie.childrenNode[a - 'a'] == null) {
                    trie.childrenNode[a - 'a'] = new Trie();
                }
                trie = trie.childrenNode[a - 'a'];
            }
            trie.word =word;
            trie.end = true;
        }

        public Boolean search(String word) {
            Trie trie = searchPrefix(word);
            return trie != null && trie.end;
        }

        public Trie searchPrefix(String prefix) {
            Trie trie = this;
            for (char a : prefix.toCharArray()) {
                if (trie.childrenNode[a - 'a'] == null) {
                    return null;
                }
                trie = trie.childrenNode[a - 'a'];
            }
            return trie;
        }
    }
}
