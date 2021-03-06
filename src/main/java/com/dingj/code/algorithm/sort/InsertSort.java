package com.dingj.code.algorithm.sort;

/**
 * 直接插入排序
 * 将一个记录插入到已经排好的有序表中，从而得到一个新的、记录数增1的有序表。
 * <p>
 * 对于给定的一组记录，初始时假定第一个记录自成一个有序序列，其余记录为无序序列。
 * 接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到其之前的有序序列中，直到最后一个记录插到有序序列中为止。
 * <p>
 * 最差情况：反序，需要移动n*(n-1)/2个元素
 * 最好情况：正序，不需要移动元素
 * 数组在已排序或者是“近似排序”时，插入排序效率的最好情况运行时间为O(n)；
 * 插入排序最坏情况运行时间和平均情况运行时间都为O(n2)。
 * <p>
 * 稳定
 * 直接插入排序法比冒泡和简单选择排序的性能要好一些。
 */
public class InsertSort {

    public static void insertSort(int[] arry) {
        int i, j;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历n-1
        for (i = 1; i < arry.length; i++) {
            j = i;
            target = arry[i];// 从第二个元素作为循环要插入的数据

            while (j > 0 && target < arry[j - 1]) {
                arry[j] = arry[j - 1];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            arry[j] = target;// 直到要插入的元素不小于第j个元素,将target插入到数组中
        }
    }

}
