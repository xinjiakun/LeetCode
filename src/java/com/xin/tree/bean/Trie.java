package com.xin.tree.bean;


/**
 * @Classname Trie
 * @Description 前缀树
 * @Date 2021/9/16 17:54
 * @Created by xinjiakun
 */
public class Trie {
    private Trie[] childrenNode;
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
