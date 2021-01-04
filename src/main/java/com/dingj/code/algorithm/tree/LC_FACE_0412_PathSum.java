package com.dingj.code.algorithm.tree;

/**
 * 面试题 04.12. 求和路径
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_FACE_0412_PathSum {

    private int res = 0;

    public int pathSum(TreeNode root, int sum) {
        // 获得树的深度
        int dep = depth(root);
        // 定义路径数组 存放每一层的节点值
        int[] paths = new int[dep];
        pathSum(root, sum, 0, paths);
        return res;
    }


    public void pathSum(TreeNode root, int sum, int level, int[] paths) {
        if (root == null)
            return;
        paths[level] = root.val;
        int t = 0;
        // 从后往前累加 如果结果等于sum 即满足条件
        for (int i = level; i >= 0; i--) {
            t += paths[i];
            if (t == sum) {
                res += 1;
            }
        }
        pathSum(root.left, sum, level + 1, paths);
        pathSum(root.right, sum, level + 1, paths);
    }

    // 获得节点的深度
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }



    // 解法2 ：
    // 不要求根节点，也不要求叶子节点，说明任意组合都可以
    // 因此需要考虑两层递归，第一次递归处理当前节点往下找的情况，第二层递归处理当前节点的左子树和右子树
    // 采用一个全局变量count记录最终的结果
    public int pathSum2(TreeNode root, int sum){
        if(root == null) return 0;
        finsSum(root,sum);
        pathSum2(root.left,sum);
        pathSum2(root.right,sum);
        return count;
    }

    private int count = 0;
    private void finsSum(TreeNode node, int sum){
        if(node == null) return;
        sum = sum - node.val;
        if(sum == 0){
            count++;
        }
        finsSum(node.left,sum);
        finsSum(node.right,sum);
    }



}
