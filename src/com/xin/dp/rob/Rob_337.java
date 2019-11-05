package com.xin.dp.rob;

import com.xin.tree.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinjiakun
 * @title: Rob_198
 * @projectName coding
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 *                 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 *                  自底向上递归进行这个dp运算，令dp[i]代表以i结点为根节点的子树的最大偷窃金额值，计算结束后将dp值直接保存在i结点的val值当中返回。
 *                  状态方程为dp[root] = Max(dp[l]+dp[r], root.val+dp[ll]+dp[lr]+dp[rr]+dp[rl]);
 * @date 2019/11/5 15:53
 */
public class Rob_337 {
    public int rob(TreeNode root) {
        return helper(root).val;
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) {//对于左/右子树为空的非叶节点，在其左/右添加一棵两层值为0的满二叉树
            root = new TreeNode(0);
            return helper(root);
        } else if (root.left == null && root.right == null) {//对于叶子结点，给其添加值为0的左右子结点。
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            return root;
        }
        root.left = helper(root.left);
        root.right = helper(root.right);
        root.val = Math.max(root.val + root.left.left.val + root.left.right.val + root.right.left.val + root.right.right.val, root.left.val + root.right.val);
        return root;
    }
}
