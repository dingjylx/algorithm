package com.dingj.code.algorithm.sort;

/**
 * 希尔排序
 * 是插入排序的高级版，减少了元素移动位置的次数，又叫递减增量排序。
 * 在要排序的一组数中，根据某一增量分为若干子序列,并对子序列分别进行插入排序；
 * 然后逐渐将增量减小，重复上述过程；
 * 直至增量为1，此时数据序列基本有序，最后进行插入排序。
 *
 * 不稳定
 * 平均时间复杂度：O(nlog2n)
 * 最坏：O(n1.5)
 */
public class ShellSort {

    public static void shellSort(int[] arr) {

        int len = arr.length;
        // 增量每次都/2
        for (int step = len / 2; step > 0; step /= 2) {

            // 从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < len; i++) {
                int j = i;
                int tmp = arr[i];// 从第二个元素作为循环要插入的数据

                // j-step就是代表与它同组隔壁的元素
                while (j - step > 0 && tmp < arr[j - step]) {
                    arr[j] = arr[j - step];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                    j = j - step;
                }
                arr[j] = tmp;// 直到要插入的元素不小于第j个元素,将target插入到数组中
            }
        }
    }
}
