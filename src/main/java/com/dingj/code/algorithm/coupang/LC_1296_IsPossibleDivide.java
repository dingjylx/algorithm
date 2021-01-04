package com.dingj.code.algorithm.coupang;

import java.util.PriorityQueue;

/**
 * 1296. 划分数组为连续数字的集合
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 True；否则，返回 False。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_1296_IsPossibleDivide {


    /**
     * 优先队列
     * 每次从队首出队一个数 i，就需要依次从堆中再移除 i + 1, i + 2, ..., i + (k - 1) ，只要移除失败，就可以直接返回 false；
     * 如果每次都能移除成功，最后优先队列就会为空，直接返回 true 即可。
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0)
            return false;

        // 优先队列的作用是保证每次取出的元素都是队列中权值最小的。
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);
        for (int n : nums) {
            minHeap.offer(n);
        }

        while (!minHeap.isEmpty()) {
            // 获取并删除队首元素
            Integer top = minHeap.poll();

            for (int i = 1; i < k; i++) {
                // 从 1 开始，正好需要移除 k - 1 个元素
                if (!minHeap.remove(top + i)) { // 用于删除队列中跟o相等的某一个元素（如果有多个相等，只删除一个）
                    // 如果移除失败，说明划分不存在，直接返回 false 即可
                    return false;
                }
            }
        }

        return true;

    }

}
