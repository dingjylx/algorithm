package com.dingj.code.algorithm.coupang;

import com.dingj.code.algorithm.tree.TreeNode;

/**
 * 776. 拆分二叉搜索树
 * 给你一棵二叉搜索树（BST）、它的根结点 root 以及目标值 V。
 * <p>
 * 请将该树按要求拆分为两个子树：其中一个子树结点的值都必须小于等于给定的目标值 V；另一个子树结点的值都必须大于目标值 V；树中并非一定要存在值为 V 的结点。
 * <p>
 * 除此之外，树中大部分结构都需要保留，也就是说原始树中父节点 P 的任意子节点 C，假如拆分后它们仍在同一个子树中，那么结点 P 应仍为 C 的子结点。
 * <p>
 * 你需要返回拆分后两个子树的根结点 TreeNode，顺序随意。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_776_SplitBST {

    /**
     * 递归解法
     * 比较root.val和v的大小
     * ans[] = splitBST(root, V),其中 ans[0] 表示拆分后的左子树，ans[1] 表示拆分后的右子树；
     *
     * @param root
     * @param V
     * @return
     */
    public TreeNode[] splitBST(TreeNode root, int V) {

        if (root == null) {
            return new TreeNode[]{null, null};
        } else if (root.val <= V) {
            TreeNode[] bns = splitBST(root.right, V);
            root.right = bns[0];
            bns[0] = root;
            return bns;
        } else {
            TreeNode[] bns = splitBST(root.left, V);
            root.left = bns[1];
            bns[1] = root;
            return bns;
        }
    }
}
