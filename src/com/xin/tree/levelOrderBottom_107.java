package com.xin.tree;

import com.xin.tree.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 辛佳锟
 * @title: levelOrderBottom_107
 * @projectName LeetCode
 * @description: 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @date 2019/10/26 17:12
 */
public class levelOrderBottom_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList();
        if(root != null){//判断
            queue.add(root);
        }
        method(queue,lists);
        return lists;
    }
    public void method(Queue<TreeNode> queue ,List<List<Integer>> listList){
        if(queue.isEmpty()){//容器非空判断不能用null
            return;
        }
        Queue<TreeNode> queue1 = new LinkedList();
        List<Integer> list = new LinkedList();
        TreeNode node ;
        while (!queue.isEmpty()){//容器非空判断不能用null
            node = queue.element();
            queue.remove();
            list.add(node.val);
            if(node.left != null){
                queue1.add(node.left);
            }
            if(node.right != null){
                queue1.add(node.right);
            }
        }
        method(queue1,listList);
        listList.add(list);
    }
}
