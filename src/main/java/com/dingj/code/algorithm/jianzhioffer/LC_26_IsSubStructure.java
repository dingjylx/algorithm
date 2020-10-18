package com.dingj.code.algorithm.jianzhioffer;


import com.dingj.code.algorithm.tree.TreeNode;

/**
 * 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class LC_26_IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        // 先从根节点判断B是不是A的子节点，如果不是再分别从左右子树判断，只要有一个为true,说明B是A的子结构
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSub(TreeNode A, TreeNode B) {
        // 如果B为空，说明B访问完了，确定树A的子结构
        if (B == null)
            return true;
        // 如果B不为空A为空，或者这两个节点值不同，说明B不是A的子结构，直接返回
        if (A == null || A.val != B.val)
            return false;
        // 当前节点比较完后，继续比较左右子节点
        return isSub(A.left, B.left) && isSub(A.right,B.right);

    }

}
