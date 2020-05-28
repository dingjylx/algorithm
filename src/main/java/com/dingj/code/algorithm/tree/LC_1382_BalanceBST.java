package com.dingj.code.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. 将二叉搜索树变平衡
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 * 如果有多种构造方法，请你返回任意一种。
 */
public class LC_1382_BalanceBST {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortList = new ArrayList<>();
        getList(root,sortList);
        return buildTree(sortList,0, sortList.size() - 1);
    }


    // 有序链表构造平衡二叉树
    private TreeNode buildTree(List<Integer> sortList, int start, int end) {
        if (start > end){
            return null;
        }
        int mid = start + (end - start >> 1);
        TreeNode root = new TreeNode(sortList.get(mid));
        // 递归构造左右子树
        root.left = buildTree(sortList,start,mid-1);
        root.right = buildTree(sortList,mid+1,end);
        return root;
    }

    /**
     * 中序遍历，获得节点数组
     *
     * @param root
     */
    private void getList(TreeNode root, List<Integer> sortList) {
        if (root == null) return;
        getList(root.left, sortList);
        sortList.add(root.val);
        getList(root.right, sortList);
    }
}
