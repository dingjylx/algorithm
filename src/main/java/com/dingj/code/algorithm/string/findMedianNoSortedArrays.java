package com.dingj.code.algorithm.string;

import java.util.PriorityQueue;

/**
 * 怎么求一个无序数组（长度为n）的中位数
 * <p>
 * 常规思路：
 * 首先将数组排序，然后直接从排序数组中找出中位数。这个算法的复杂度是O（nlogn），就是排序的复杂度。
 * <p>
 * 巧妙算法：使用最小堆
 */
public class findMedianNoSortedArrays {

    public static double median(int[] array) {
        int heapSize = array.length / 2 + 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < heapSize; i++) {
            heap.add(array[i]);
        }

        for (int i = heapSize; i < array.length; i++) {
            if (heap.peek() < array[i]) {
                heap.poll();
                heap.add(array[i]);
            }
        }
        if (heapSize % 2 == 1) {
            return (double) heap.peek();
        } else {
            return (double) (heap.poll() + heap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] array = {3,6,5,1,2,7,8,9,10,11};
        System.out.println(median(array));
    }

}
