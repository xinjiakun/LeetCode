package com.xin.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 辛佳锟
 * @title: levelOrderBottom_107
 * @projectName LeetCode
 * @description: 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 解法2 迭代 queue
 * @date 2019/10/26 17:12
 */
public class Solution_102_2 {
    public List<List<Integer>> list = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        Solution_102_2 solution102 = new Solution_102_2();
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return list;
        }
        helper(root,0);
        return list;
    }
    public void helper(TreeNode treeNode, int level){
        if(list.size() == level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(treeNode.val);
        if(treeNode.left != null){
            helper(treeNode.left, level+1);
        }
        if(treeNode.right != null){
            helper(treeNode.right, level+1);
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
