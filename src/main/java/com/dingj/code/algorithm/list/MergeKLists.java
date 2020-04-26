package com.dingj.code.algorithm.list;

public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 方法1：两两合并
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // 将list[0]作为最终合并的链表，然后将list[0]和list[1]合并成list[0-1]
        // 再将lists[0-1]和lists[2]合并，如此反复最终lists[0]就是最终结果
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = merge(res, lists[i]);
        }
        return res;

    }

    /**
     * 方法二：分治算法
     * 合并数组中第k个链表到第1个链表，合并数组中第k-1个链表到第2个链表，依次这样操作...
     * 一轮合并之后，新链表分布在数组的 第1 到 第(k+1)/2个链表中，继续1这样的合并直到新链表只在数组第一个位置。
     * 返回数组第一个元素，即合并之后的链表。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[1] = merge(lists[i], lists[len - 1 - i]);
            }
            len = (len + 1) / 2;
        }
        return lists[0];
    }

    /**
     * 合并两个有序链表1：递归
     *
     * @param a
     * @param b
     * @return
     */
    private ListNode merge(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        if (a.val <= b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }

    /**
     * 合并两个有序链表2：迭代
     *
     * @param a
     * @param b
     * @return
     */
    private ListNode merge2(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        // 假的头结点
        ListNode prev = head;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                prev.next = a;
                a = a.next;
            } else {
                prev.next = b;
                b = b.next;
            }
            prev = prev.next;
        }
        // 特殊情况：比较两个链表已经为空，则剩余的接上
        prev.next = a == null ? b : a;
        return head.next;
    }


}
