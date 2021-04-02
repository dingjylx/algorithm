package com.dingj.code.algorithm.linkedList;

import com.dingj.code.algorithm.tree.ListNode;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class LC_876_MiddleNode {

    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!= null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
