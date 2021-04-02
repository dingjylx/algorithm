package com.dingj.code.algorithm.linkedList;

import com.dingj.code.algorithm.tree.ListNode;

/**
 * 206
 * 反转一个单链表。
 */
public class LC_206_ReverseList {

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList1(head.next);
        //head 的下一个节点指向head
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }


    /**
     * 迭代
     * 事先声明一个空节点
     * 在遍历列表时，将当前节点的next 指针改为指向前一个元素。
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
