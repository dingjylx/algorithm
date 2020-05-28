package com.dingj.code.algorithm.tree;


import java.util.Random;

/**
 * 108 将有序数组转换为二叉搜索树
 * 要求：构建高度平衡二叉搜索树，节点左右子树高度差不超过1
 */
public class LC_108_SortedArrayToBST {

    int[] nums;
    Random rand = new Random();

    // 按照二分的思想。中点作为根节点。
    // 中点左边的数作为左子树，中点右边的数作为右子树。

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    // 中序遍历：选择任意一个中间位置元素作为根节点
    private TreeNode helper(int left ,int right){
        if(left > right) return null;
        // 取中间数
        int mid = (left + right) / 2;
        if((left + right) %2 == 1)
            mid += rand.nextInt(2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid-1);
        root.right = helper(mid + 1, right);
        return root;
    }


    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt(2));
    }
}
