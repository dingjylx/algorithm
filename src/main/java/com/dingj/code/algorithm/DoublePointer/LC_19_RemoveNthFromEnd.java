package com.dingj.code.algorithm.DoublePointer;

import com.dingj.code.algorithm.tree.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LC_19_RemoveNthFromEnd {
    /**
     * 快慢指针
     * fast先走n步，然后fast slow一起走，相距n，直到fast到末尾，则slow指向倒数第n个
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre, slow = pre;
        // fast先走n步
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        // 快慢指针同时走，当快指针走到末尾，则慢指针刚好指向n+1节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除第n节点，改变指向即可
        slow.next = slow.next.next;
        return pre.next;
    }
}
