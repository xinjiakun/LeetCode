package com.xin.bfs;

import javafx.util.Pair;

import java.util.*;

/**
 * @author xinjiakun
 * @title: LadderLength_127
 * @projectName coding
 * @description: 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *                  每次转换只能改变一个字母。
 *                  转换过程中的中间单词必须是字典中的单词。
 *                  BFS 广度优先 单词数组转化为 无向图节点(权值为1)  求最短长度等价于求起始节点到末节点的最短路径
 * @date 2019/11/6 15:42
 */
public class LadderLength_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();  //key为中间状态 改变字符用*表示 (例如:acb<=>a*b<=>adb   key为 a*b)  value为 具有中间状态的单词
        for (String word : wordList) { //遍历单词数组
            for (int i = 0; i < word.length(); i++) {//遍历每一种单词的中间状态
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);//生成key值
                ArrayList<String> list = map.getOrDefault(newWord, new ArrayList<String>());//  getOrDefault :key存在则返回value 不存在则返回传递的默认值
                list.add(word);//保存到该key的value集合下
                map.put(newWord, list);//更新该key的value
            }

        }
        //pair 键值对
        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();//广搜核心  <=>二叉树层次遍历  将节点按层次放到队列
        //保存 已遍历的单词  防止重复遍历
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        //将起始节点放到队列和防重复map中
        queue.add(new Pair<>(beginWord, 1));
        visited.put(beginWord, true);
        //遍历队列
        while (!queue.isEmpty()) {
            //弹出队首节点
            Pair<String, Integer> remove = queue.remove();
            //查找弹出节点相连接的节点
            for (int i = 0; i < remove.getKey().length(); i++) {
                String newWord = remove.getKey().substring(0, i) + "*" + remove.getKey().substring(i + 1);
                ArrayList<String> list = map.getOrDefault(newWord, new ArrayList<String>());
                for (String a : list) {
                    //找到结束单词
                    if (a.equals(endWord)) {
                        return remove.getValue() + 1;
                    }
                    //未访问过该单词   containsKey: 该key存在返回true  不存在返回false
                    if (!visited.containsKey(a)) {
                        //标志已访问 加入队列
                        visited.put(a,true);
                        //未找到结束单词 加入队尾
                        queue.add(new Pair<String, Integer>(a,remove.getValue()+1));
                    }
                }
            }
        }
        return 0;
    }
}
