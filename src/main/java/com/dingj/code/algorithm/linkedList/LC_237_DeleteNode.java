package com.dingj.code.algorithm.linkedList;

import com.dingj.code.algorithm.tree.ListNode;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 */
public class LC_237_DeleteNode {

    /**
     * 与下个节点交换，因为删除的不是末尾节点，肯定可行。。
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


