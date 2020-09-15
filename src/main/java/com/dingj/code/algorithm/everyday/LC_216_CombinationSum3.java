package com.dingj.code.algorithm.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_216_CombinationSum3 {


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }


    /**
     * @param res   结果集
     * @param list 临时选择集合
     * @param k 个数
     * @param start 因为不能有重复的集合以及集合中不能有重复的数字，所以这里的i不能从0开始，要从上一个选择之后的下一个值开始
     * @param n 和
     */
    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        //终止条件，如果满足这个条件，再往下找也没什么意义了
        if (list.size() == k || n <= 0) {
            // 如果找到一组合适的话，就添加到结果集中
            if (list.size() == k && n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            // 做选择
            list.add(i);
            // 递归
            dfs(res, list, k, i + 1, n - i);
            // 撤销选择
            list.remove(list.size() - 1);
        }
    }


}
