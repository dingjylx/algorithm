package com.dingj.code.algorithm.tree;

import java.util.Objects;
import java.util.Stack;


/**
 * 面试题54，二叉搜索树的第k大节点
 */
public class LC_FACE_54_KthLargest {

    int count = 1;
    int result = -1;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        kthLargest(root);
        return result;

    }

    /**
     * 中序递归算法
     * 二叉排序树的中序遍历正好是递增序列，左-中-右
     * 中序遍历的结果，如果是左子树在前，右子树在后，遍历结果就是由小到大、如果是右子树在前，左子树在后，遍历结果就是由大到小
     *
     * @param root
     */
    public void kthLargest(TreeNode root) {
        if (Objects.nonNull(root)) {
            kthLargest(root.right);
            if (count == 1) {
                result = root.val;
                count--;
                return;
            }
            count--;
            kthLargest(root.left);
        }
    }


    /**
     * 迭代法
     * 一个节点的右节点比这个节点的左节点及父节点都大，利用栈结构迭代找到最右边的节点，
     * 当右节点遍历完，再看下这个节点有没有左节点（因为这个右节点的左节点也比这个右节点的父节点大），
     * 左右都遍历完，再输出当前节点。
     * 同理，当输出完当前节点，再看当前节点有没有左节点，没有的话，再回到当前节点的父节点，依次类推，这样可以按照从大到小排序输出
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest2(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();
        while (Objects.nonNull(root) || !stack.empty()) {
            while (Objects.nonNull(root)) {
                stack.push(root);
                root = root.right;
            }
            TreeNode pop = stack.pop();
            if (count == k) {
                return pop.val;
            }
            count++;
            root = pop.left;

        }
        return 0;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode right1 = new TreeNode(6);
        TreeNode right2 = new TreeNode(7);
        TreeNode left1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        root.left = left2;
        left2.left = left1;
        root.right = right2;
        right2.left = right1;
        LC_FACE_54_KthLargest kth = new LC_FACE_54_KthLargest();
        // 递归
        System.out.println(kth.kthLargest(root, 2));
        // 栈迭代
        System.out.println(kth.kthLargest2(root, 2));
    }

}
