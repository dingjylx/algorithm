package com.dingj.code.algorithm.everyday;

import com.dingj.code.algorithm.tree.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class LC_530_GetMinimumDifference {


    int ans;
    int pre;

    /**
     * 思路，比较相邻节点对差的最小值
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root){
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }


    public void dfs(TreeNode root){
        if(root == null) return;
        // 左子树
        dfs(root.left);
        // 当前节点
        if(pre == -1){
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        // 右子数
        dfs(root.right);
    }





}
