package com.dingj.code.algorithm.tree;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 例如，给出
 * <p>
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_105_BuildTree {

    /**
     * 思路：
     * 1、前序遍历第一个节点是根节点
     * 2、从中序遍历找到根节点的位置，然后分别递归构造左右子树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 将中序遍历树组转成map，查找位置效率高， O（1）
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
        if (p_start > p_end || i_start > i_end) {
            return null;
        }

        // 根节点值
        int root_val = preorder[p_start];
        // 构造根节点
        TreeNode root = new TreeNode(root_val);
        // 根节点在中序树组的位置
        int i_root_index = map.get(root_val);
        // 左子树节点的个数
        int left_num = i_root_index - i_start;
        // 递归构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + left_num, inorder, i_start, i_root_index - 1, map);
        // 递归构造右子数
        root.right = buildTreeHelper(preorder, p_start + left_num + 1, p_end, inorder, i_root_index + 1, i_end, map);
        return root;
    }


}
