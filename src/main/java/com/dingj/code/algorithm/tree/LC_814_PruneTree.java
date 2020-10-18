package com.dingj.code.algorithm.tree;

/**
 * 二叉树剪枝
 * 给定二叉树根结点root，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_814_PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    /**
     * 判断以node为根节点的子树中是否包含1：
     * 1、node本身不为1
     * 2、以node左右子节点为根的子树中不包含1
     * 如果不包含1，则将对应的指针置为空
     *
     * @param node
     * @return
     */
    public boolean containsOne(TreeNode node) {
        if (node == null)
            return false;
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1) node.left = null;
        if (!a2) node.right = null;
        return node.val == 1 || a1 || a2;
    }

    public static void main(String[] args) {
        String s = "adfas{sdf msg:\"sd ds sd \"}";
        System.out.println(s.split("msg")[1]);
    }


}
