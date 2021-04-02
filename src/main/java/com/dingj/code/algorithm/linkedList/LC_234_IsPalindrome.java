package com.dingj.code.algorithm.linkedList;

import com.dingj.code.algorithm.tree.ListNode;

import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 * 1->2->2->1
 */
public class LC_234_IsPalindrome {

    /**
     * 快慢指针 O(1)
     * 整个流程可以分为以下五个步骤：
     * 1、找到前半部分链表的尾节点。
     * 2、反转后半部分链表。
     * 3、判断是否回文。
     * 4、恢复链表，同2的方法，再执行一次
     * 5、返回结果。
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        // 找到前半部分链表的尾节点
        ListNode firstHalfEnd = endOfFirstHalf(head);
        // 并反转后半部分链表
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while(result && p1 != null && p2 !=null){
            if(p1.val != p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    /**
     * 寻找前半部分链表的尾节点
     * @param head
     * @return
     */
    private ListNode endOfFirstHalf(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next !=null){ // 注意结束条件
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
