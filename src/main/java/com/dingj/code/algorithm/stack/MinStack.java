package com.dingj.code.algorithm.stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 解法：
 * 链表实现栈的基本功能，Node节点增加一个min字段，每次加入节点放头部，并更新min
 */
public class MinStack {
    class Node {
        int value;
        int min;
        Node next;

        Node(int x, int min) {
            this.value = x;
            this.min = min;
            next = null;
        }
    }

    Node head;

    // 每次加入的节点放头部
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            //当前值和之前头结点的最小值较小的做为当前的 min
            Node n = new Node(x, Math.min(x, head.min));
            n.next = head;
            head = n;
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        if (head != null) {
            return head.value;
        }
        return -1;
    }

    public int getMin() {
        if (head != null) {
            return head.min;
        }
        return -1;
    }
}
