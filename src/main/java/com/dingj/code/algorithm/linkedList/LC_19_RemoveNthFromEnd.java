package com.dingj.code.algorithm.linkedList;

import com.dingj.code.algorithm.tree.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 要求一次遍历
 */
public class LC_19_RemoveNthFromEnd {


    /**
     * 如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。
     * 删掉slow所指向的节点就可以了。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // 快指针先走n步
        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }

        // 快慢指针同时走，当快指针走到末尾，则慢指针刚好指向n+1节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除第n节点，改变指向即可
        slow.next = slow.next.next;
        return dummyHead.next;
    }

}
