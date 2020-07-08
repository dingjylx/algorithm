package com.dingj.code.algorithm.everyday;

import com.dingj.code.algorithm.tree.TreeNode;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class LC_112_HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        // 达到叶子节点时，递归终止，判断sum是否符合条件
        // 同时判断节点的左右子树同时为空才是叶子节点。
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        // 递归地判断root节点的左孩子和右孩子。
        // 只要左右任意一个孩子的为空时 sum == 0 就返回 True
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }
}
