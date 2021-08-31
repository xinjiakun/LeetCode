package com.xin.dfs;

import com.xin.tree.bean.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author xinjiakun
 * @title: MaxPathSum_124
 * @projectName coding
 * @description: 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 递归遍历
 * @date 2019/11/12 16:40
 */
public class MaxPathSum_124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子树的累加最大值
        int left = Math.max(helper(root.left), 0);
        //右子树的累加最大值
        int right = Math.max(helper(root.right), 0);
        //左右子树值＋当前节点值
        max = Math.max(left + right + root.val, max);
        //返回值只能是左右子树中的一条路
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MaxPathSum_124().maxPathSum(root));
    }
}
