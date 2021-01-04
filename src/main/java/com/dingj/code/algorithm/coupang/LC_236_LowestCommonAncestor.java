package com.dingj.code.algorithm.coupang;

import com.dingj.code.algorithm.tree.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LC_236_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 递归终止条件
        // 1 越过叶节点，直接返回null
        // 2 当root等于p/q，直接返回root
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归左右子节点，记录返回值
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 返回值
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

}
