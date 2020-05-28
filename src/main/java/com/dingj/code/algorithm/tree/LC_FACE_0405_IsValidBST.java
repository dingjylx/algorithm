package com.dingj.code.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.05. 合法二叉搜索树
 */
public class LC_FACE_0405_IsValidBST {


    /**
     * 二叉搜索树性质：根节点的值大于左子树所有节点的值，小于右子树所有节点的值。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // 对二叉搜索树做中序遍历，遍历得到一个递增数组，若不是递增，则不是二叉搜索树。
    private void inOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left != null) {
                inOrder(node.left, list);
            }
            list.add(node.val);
            if (node.right != null) {
                inOrder(node.right, list);
            }
        }
    }
}


