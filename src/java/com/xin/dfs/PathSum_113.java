package com.xin.dfs;

import com.xin.tree.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinjiakun
 * @title: PathSum_113
 * @projectName coding
 * @description: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * @date 2019/11/11 10:26
 */
public class PathSum_113 {
    public static List<List<Integer>> paths;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        paths = new ArrayList<>();
        if (root == null) {//sum=0 不为base  可能存在负数
            return paths;
        }
        helper(root, sum, new ArrayList<>());
        return paths;
    }

    private boolean helper(TreeNode root, int sum, List path) {
        if (root == null) {  //到叶子节点
            return true;
        } else {
            path.add(root.val);//
            if (helper(root.left, sum - root.val, path) && helper(root.right, sum - root.val, path)) {//递归查找到叶子节点
                if ((sum - root.val) == 0 && root.left == null && root.right == null) { //判断是否存在目标路径 (必须判断左右子节点是否为null
                                                                                        // ，因为递归删除后同样为true  防止未递归到叶子节点 正好等于路径长度)
                    paths.add(new ArrayList<>(path));//存在目标路径 则保存到paths    不能直接传path  （传引用）
                }
                path.remove(path.size() - 1);//
            }
            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        new PathSum_113().pathSum(root, 22);
        System.out.println(paths.get(0).get(0));
    }
}
