package com.dingj.code.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class LC_46_Permute {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }


    private void backtrack(int[] nums, LinkedList<Integer> track) {
        //触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LC_46_Permute permute = new LC_46_Permute();
        List<List<Integer>> lists = permute.permute(nums);
        System.out.println(lists);
    }
}
