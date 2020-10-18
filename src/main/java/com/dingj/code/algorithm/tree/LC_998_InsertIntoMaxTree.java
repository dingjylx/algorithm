package com.dingj.code.algorithm.tree;

/**
 * 998. 最大二叉树 II
 *
 最大树定义：一个树，其中每个节点的值都大于其子树中的任何其他值。
 */
public class LC_998_InsertIntoMaxTree {
    public TreeNode insertIntoMaxTree(TreeNode root, int val){
        // 如果根节点为空或者小于val，将root放入左边
        if(root == null || root.val < val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        // 否则一直在右子数递归
        TreeNode temp = insertIntoMaxTree(root.right, val);
        root.right = temp;
        return root;

    }

}
