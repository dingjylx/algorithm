package com.dingj.code.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 */
public class InorderSuccessor {

    /**
     * 方法1解题思路：
     * 所谓 p 的后继节点，就是这串升序数字中，比 p 大的下一个。
     * <p>
     * 如果 p 大于当前节点的值，说明后继节点一定在 RightTree的最左节点
     * 如果 p 等于当前节点的值，说明后继节点一定在 RightTree的最左节点
     * 如果 p 小于当前节点的值，说明后继节点一定在 LeftTree 或自己的最左节点就是
     * 递归调用 LeftTree，如果是空的，说明当前节点就是答案
     * 如果不是空的，则说明在 LeftTree 已经找到合适的答案，直接返回即可
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode temp = inorderSuccessor(root.left, p);
            return temp == null ? root : temp;
        }

    }


    /**
     * 方法2：中序遍历转list，查找大于p的下个节点
     */
    List<TreeNode> list = new ArrayList<>();

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        midsearch(root, p);
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (node.val > p.val) return node;
        }
        return null;
    }

    private void midsearch(TreeNode root, TreeNode p) {
        if (root == null) return;
        midsearch(root.left, p);
        list.add(root);
        midsearch(root.right, p);
    }

}
