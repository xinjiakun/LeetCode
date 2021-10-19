package com.xin.list;

import java.util.*;

/**
 * @Classname WordDictionary
 * @Description 添加与搜索单词 - 数据结构设计  211
 * @Date 2021/10/19 12:25
 * @Created by xinjiakun
 */
public class WordDictionary {
    Map<Integer, List<String>> value = null;

    public WordDictionary() {
        value = new HashMap<>();
    }

    public void addWord(String word) {
        int length = word.length();
        List<String> stringList = value.get(length) == null ? new ArrayList() : value.get(length);
        stringList.add(word);
        value.put(length, stringList);
    }

    public boolean search(String word) {
        int length = word.length();
        List<String> stringList = value.get(length);
        if (stringList == null) {
            return false;
        }
        for (String item : stringList) {
            for (int i = 0; i < length; i++) {
                if (word.charAt(i) != '.' && word.charAt(i) != item.charAt(i)) {
                    break;
                } else if (i == length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));


    }
}
