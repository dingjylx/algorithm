package com.dingj.code.algorithm.LRU;

/**
 * 双向链表的节点
 */
public class Node {
    public int key, val;
    public Node prev, next;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
