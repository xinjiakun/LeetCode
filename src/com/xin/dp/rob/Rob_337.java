package com.xin.dp.rob;

import com.xin.tree.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinjiakun
 * @title: Rob_198
 * @projectName coding
 * @description: 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 *                 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
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
