package com.dingj.code.algorithm.linkedList;

import com.dingj.code.algorithm.tree.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 */
public class LC_203_RemoveElements {
    /**
     * 哨兵节点（虚拟头结点）：
     * 哨兵节点广泛应用于树和链表中，如伪头、伪尾、标记等，
     * 它们是纯功能的，通常不保存任何数据，其主要目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除。
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;

    }
}
