package com.dingj.code.algorithm.tree;

import java.util.HashMap;

/**
 * 865. 具有所有最深结点的最小子树
 * 给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
 * <p>
 * 如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
 * <p>
 * 一个结点的子树是该结点加上它的所有后代的集合。
 * <p>
 * 返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_865_SubtreeWithAllDeepest {

    HashMap<TreeNode, Integer> map = new HashMap<>();


    /**
     * 用一个map记录所有节点的深度。
     * 从根节点开始,如果左右子树的深度一致,直接返回根节点。否则递归判断深度较大的子树。
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root);
        return ans(root);
    }


    public TreeNode ans(TreeNode root) {
        int L = map.get(root.left);
        int R = map.get(root.right);

        if (L == R) {
            return root;
        } else if (L > R) {
            return ans(root.left);
        } else if (L < R) {
            return ans(root.right);
        }
        return null;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            map.put(root, 0);
            return;
        }
        dfs(root.left);
        dfs(root.right);
        map.put(root, Math.max(map.get(root.left), map.get(root.right)) + 1);
    }

}
