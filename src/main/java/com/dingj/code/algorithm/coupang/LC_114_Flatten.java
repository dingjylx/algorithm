package com.dingj.code.algorithm.coupang;

import com.dingj.code.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 */
public class LC_114_Flatten {

    /**
     * 前序遍历，然后构造树，左节点null
     * @param root
     */
    public void flatten(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        preorder(root,list);

        for(int i = 1; i < list.size(); i++){
            TreeNode prev = list.get(i-1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }


    private void preorder(TreeNode root, List<TreeNode> list){
        if(root == null)
            return;
        list.add(root);
        preorder(root.left,list);
        preorder(root.right,list);
    }

}
