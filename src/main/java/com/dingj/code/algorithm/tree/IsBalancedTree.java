package com.dingj.code.algorithm.tree;

/**
 * 面试题 04.04. 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 */
public class IsBalancedTree {
    /**
     * 解法：从顶到底，
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        // 拿到节点的左子树和右子树的深度，如果相差大于1，那么不是一颗平衡树
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) return false;
        // 递归检查这个节点的左子节点和右子节点
        return isBalanced(root.left) && isBalanced(root.right);

    }

    // 获取从某个节点开始的深度
    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

}
