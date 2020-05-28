package com.dingj.code.algorithm.LRU;

import java.util.HashMap;

/**
 * 用哈希链表实现，可快速插入删除，和查找
 */
public class LRUCache {
    // key -> Node(key,val)
    private HashMap<Integer, Node> map;
    // Node(k1,v1) -> Node(k2,v2)
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node x = new Node(key, val);
        if (map.containsKey(key)) {
            // 删除旧的节点，新的插入头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新map中对应的值
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}
