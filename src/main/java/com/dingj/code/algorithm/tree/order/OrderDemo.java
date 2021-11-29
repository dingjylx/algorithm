package com.dingj.code.algorithm.tree.order;

import com.dingj.code.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class OrderDemo {


    /**
     * 前序遍历
     * 先根节点，再左子树，最后右子树
     *
     * @param root
     */
    // 1、递归实现
    public static void preOrder1(TreeNode root) {
        if (root != null) {
            System.out.println(root.val + "->");
            preOrder1(root.left);
            preOrder1(root.right);
        }
    }

    // 2、栈实现
    public static void preOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.println(node.val + "->");
                stack.push(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                node = temp.right;
            }
        }
    }


    /**
     * 中序遍历
     * 先左子树，再根节点，最后右子树
     *
     * @param root
     */
    // 1、递归实现
    public static void inOrder1(TreeNode root) {
        if (root != null) {
            inOrder1(root.left);
            System.out.println(root.val + "->");
            inOrder1(root.right);
        }
    }

    // 2、栈实现
    public static void inOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                System.out.println(temp.val + "->");
                node = temp.right;
            }
        }
    }


    /**
     * 后序遍历
     * 先左子树，再右子树，最后根节点
     *
     * @param root
     */
    // 1、递归实现
    public static void postOrder1(TreeNode root) {
        if (root != null) {
            postOrder1(root.left);
            postOrder1(root.right);
            System.out.println(root.val + "->");
        }
    }

    // 2、栈实现
    public static void postOrder2(TreeNode root) {
        TreeNode cur, pre = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();// 取出栈顶元素，不删除
            // 难点：
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.println(cur.val + "->");
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
    }


    /**
     * 层序遍历
     * 若树为空,则空操作返回,否则从树的第一层,根结点开始访问,从上而下逐层遍历,在同一层中,从左往右的顺序对结点进行访问
     *
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        // 如果节点为空，返回
        if (root == null) {
            return;
        }
        // 创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点放入队列
        queue.add(root);

        /**
         * 循环判断队列是否为空,
         * 如果非空,将结点的左右孩子放入队列,并且取出数据
         * 为空的话,结束遍历
         */
        while (!queue.isEmpty()) {
            // 取出节点
            TreeNode node = queue.poll();
            // 打印节点
            System.out.println(node.val + "->");
            // 将左右孩子节点，不为空，就放入队列
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        levelOrder(root);
//        preOrder2(root);
//        inOrder2(root);
//        postOrder2(root);
    }


}
