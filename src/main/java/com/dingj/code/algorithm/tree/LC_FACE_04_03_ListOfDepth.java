package com.dingj.code.algorithm.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_FACE_04_03_ListOfDepth {

    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null){
            return new ListNode[0];
        }
        // 存储每一层的链表
        LinkedList<ListNode> res = new LinkedList<>();
        // 存储每一层的队列，先进先出，父节点出队时，左右子节点入队
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()){
            int size = queue.size();
            ListNode head = null;
            ListNode tail = null;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right !=null){
                    queue.offer(node.right);
                }
                ListNode temp = new ListNode(node.val);
                temp.next = null;
                if(head == null){
                    head = temp;
                    tail = temp;
                } else {
                    tail.next = temp;
                    tail = temp;
                }
            }
            res.add(head);
        }
        return res.toArray(new ListNode[res.size()]);
    }

    public static void main(String[] args) {

    }
}
