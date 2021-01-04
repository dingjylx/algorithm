package com.dingj.code.algorithm.tree;

import java.util.HashMap;

/**
 * 106 中序+后序构造树
 */
public class LC_106_BuildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder,0,inorder.length - 1, postorder, 0 ,postorder.length - 1, map);
    }

    public TreeNode helper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end, HashMap<Integer,Integer> map){
        if(i_start > i_end || p_start > p_end){
            return null;
        }

        // 根节点值
        int root_val = postorder[p_end];
        // 构造根节点
        TreeNode root = new TreeNode(root_val);
        // 根节点在中序的位置
        int i_root_index = map.get(root_val);
        // 左子树的节点个数
        int leftNum = i_root_index - i_start;
        // 递归构造左子树
        root.left = helper(inorder,i_start,i_root_index - 1, postorder, p_start, p_start + leftNum -1,map);
        // 递归构造右子树
        root.right = helper(inorder,i_root_index + 1, i_end, postorder, p_start + leftNum, p_end -1,map);
        return root;
    }
}
