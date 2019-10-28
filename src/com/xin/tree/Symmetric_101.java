package com.xin.tree;


import com.xin.tree.bean.TreeNode;

/**
 * @author 辛佳锟
 * @title: Symmetric_101
 * @projectName LeetCode
 * @description: 给定一个二叉树，检查它是否是镜像对称的。
 * @date 2019/10/26 10:31
 */
public class Symmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        return dymmetric(root ,root);
    }
    public boolean dymmetric(TreeNode left ,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if((left == null || right == null) || (left.val != right.val)){
            return false;
        }else {
            return dymmetric(left.left ,right.right) &&
                    dymmetric(left.right ,right.left);

        }

    }
}
