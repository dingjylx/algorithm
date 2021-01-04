package com.dingj.code.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1530. 好叶子节点对的数量
 * <p>
 * 给你二叉树的根节点 root 和一个整数 distance 。
 * <p>
 * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
 * <p>
 * 返回树中 好叶子节点对的数量 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_1530_CountPairs {


    /**
     * 后序遍历
     * 遍历到x节点时，针对其左右子节点，分别求他们所有到叶子节点的深度存到left right ,
     * 再计算左右子数的叶子节点和X节点连接的长度，是否<=distance，是的话res++。继续dfs遍历重复以上操作。
     *
     * @param root
     * @param distance
     * @return
     */
    public int countPairs(TreeNode root, int distance) {
        dfs(root, 0, distance);
        return res;
    }

    private int res = 0;

    public List<Integer> dfs(TreeNode node, int level, int distance) {
        // 存放左右子数的所有叶子节点的深度
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        if (node.left == null && node.right == null) {
            list.add(level);
        }

        // 存放左子数的所有叶子节点的深度
        List<Integer> left = dfs(node.left, level + 1, distance);
        // 存放右子数的所有叶子节点的深度
        List<Integer> right = dfs(node.right, level + 1, distance);

        for (int l : left) {
            for (int r : right) {
                // 左子树的叶子节点到X节点到距离：l-level ，左子树的叶子节点到X节点到距离：r-level
                // 计算叶子节点距离 是否满足条件
                if ((l - level + r - level) <= distance) {
                    res++;
                }
            }
        }

        // 返回给上一层
        list.addAll(left);
        list.addAll(right);
        return list;

    }


}
