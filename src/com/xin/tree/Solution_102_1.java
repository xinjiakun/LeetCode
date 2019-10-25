package com.xin.tree;

import java.util.*;

/*
    102. 二叉树的层次遍历 递归
 */
public class Solution_102_1 {
    public List<List<Integer>> list = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        Solution_102_1 solution102 = new Solution_102_1();
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
