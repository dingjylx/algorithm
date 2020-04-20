package com.dingj.code.algorithm.tree;

/**
 * 面试题36. 二叉搜索树转循环双向链表
 */
public class BSTToDoublyList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node pre;
    private Node head;

    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        // 中序遍历访问节点并连接
        inOrder(root);
        // 连接头尾节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 中序递归
     * @param cur
     */
    void inOrder(Node cur){
        // 递归出口
        if(cur == null){
            return;
        }
        // 访问左子树
        inOrder(cur.left);
        // 将当前节点和上一节点连接
        if(pre == null){
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        // 访问右子树
        inOrder(cur.right);
    }

}
