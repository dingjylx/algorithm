package com.dingj.code.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class LC_47_PermuteUnique {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        LinkedList<Integer> track = new LinkedList();
        // 首先给数组排序~~~~!!!!
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        findUnipue(nums, visited, track);
        return res;
    }

    void findUnipue(int[] nums, boolean[] visited, LinkedList<Integer> track) {
        // 结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 选择列表
        for (int i = 0; i < nums.length; i++) {
            // 其次，我们已经选择过的，不需要再放进去了
            if (visited[i]) continue;
            // 接下来，如果当前节点与他的前一个节点一样，而且他的前一个节点已经被遍历过，那就不需要了
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                break;
            }
            // 做出选择
            track.add(nums[i]);
            visited[i] = true;
            // 进入下一层决策
            findUnipue(nums, visited, track);
            // 撤销选择
            track.removeLast();
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        int[] nums = {3,3,0,3};
        LC_47_PermuteUnique permuteUnique = new LC_47_PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(nums));
    }
}
