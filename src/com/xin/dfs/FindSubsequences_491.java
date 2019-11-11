package com.xin.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xinjiakun
 * @title: FindSubsequences_491
 * @projectName coding
 * @description: 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * dfs深搜 递归遍历数组 是否大于等于前一个 若成立则有添加和不添加两种情况 反之则跳过当前元素
 * @date 2019/11/11 14:20
 */
public class FindSubsequences_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();//set防止重复
        List<Integer> path = new ArrayList<>();
        dfs(set, path, nums, 0);//dfs递归
        return new ArrayList<>(set);//set转list
    }
    //num 数组下标
    private void dfs(Set<List<Integer>> set, List<Integer> path, int[] nums, int num) {
        if (num >= nums.length) {//遍历完数组
            if (path.size() > 1) {//防止 []空数组 或单个元素 添加
                set.add(path);
                return;
            }
        } else {
            //
            if (path.size() == 0) {//path为空 直接添加或不添加
                List<Integer> path1 = new ArrayList<>();
                path1.add(nums[num]);
                dfs(set, path, nums, num + 1);
                dfs(set, path1, nums, num + 1);

            } else {//path不为空
                if (nums[num] >= path.get(path.size() - 1)) {//判断要添加元素大于等于path末尾元素
                    List<Integer> path1 = new ArrayList<>(path);
                    path1.add(nums[num]);
                    dfs(set, path, nums, num + 1);//选择不添加
                    dfs(set, path1, nums, num + 1);//选择添加
                } else {//添加元素小于path末尾元素 直接跳过当前元素
                    dfs(set, path, nums, num + 1);
                }
            }
        }
    }
}
