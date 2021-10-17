package com.xin.tree;

/**
 * @author 辛佳锟
 * @title: Solution_230
 * @projectName LeetCode
 * @description: 二叉搜索树中第K小的元素
 * @date 2021/10/17 15:14
 */
public class Solution_230 {
    int x = 0;
    int number;
    int k;


    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        get(root);
        return number;
    }

    void get(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        get(treeNode.left);
        x++;
        if (x == k) {
            number = treeNode.val;
        }
        get(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode a1= new TreeNode(2);
        TreeNode a2= new TreeNode(1,null,a1);
        TreeNode a3= new TreeNode(4);
        TreeNode a4= new TreeNode(3,a2,a3);

        System.out.println(new Solution_230().kthSmallest(a4,1));
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
