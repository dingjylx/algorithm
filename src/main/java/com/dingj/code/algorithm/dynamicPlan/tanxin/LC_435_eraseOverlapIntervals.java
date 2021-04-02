package com.dingj.code.algorithm.dynamicPlan.tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 */
public class LC_435_eraseOverlapIntervals {

    /**
     * 找出最大不相交区间数，n - 结果，就是需要删除的最小数量
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)
            return 0;

        // 按区间end升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 排序后，第一个区间就是 x
        int x_end = intervals[0][1];
        // 至少有一个区间不重叠
        int count = 1;
        for(int[] interval : intervals){
            int start = interval[0];
            if(start >= x_end){
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
