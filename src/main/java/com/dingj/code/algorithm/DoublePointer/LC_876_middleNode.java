package com.dingj.code.algorithm.DoublePointer;

import com.dingj.code.algorithm.tree.ListNode;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class LC_876_middleNode {
    /**
     * 快慢指针
     * 用两个指针 slow 与 fast 一起遍历链表。slow 一次走一步，fast 一次走两步。那么当 fast 到达链表的末尾时，slow 必然位于中间。
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
