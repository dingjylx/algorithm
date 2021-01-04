package com.dingj.code.algorithm.sort;

/**
 * 直接选择排序
 * 在未排序序列中找到最小元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * 不稳定
 * 比较次数跟初始顺序无关，n(n-1)/2
 * 移动次数跟初始顺序有关，正序时，最少为0，反序时，最多为3n(n-1)/2
 *
 * 不论数据集合是否有序，都要每次从未排序区间找到最小的元素然后插入到已排序区间；
 * 所以选择排序的最好情况时间复杂度、最坏情况和平均时间复杂度等都是O(n2)
 */
public class SelectionSort {


    /**
     * 无序的一组数，每次从无序的数集中选择最小的一个数字，
     * 添加到有序数组的最后一位；直到无序数组为空
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int len = arr.length;

        //下标i循环到倒数第二个元素就停止了，是因为，当待排序区间只剩下一个元素的时候，它就是最后一个元素，无需再次比较；
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;// 带确定最小值的位置

            // 选最小的记录
            for (int j = i + 1; j < len; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j; // 记下目前找到的最小值所在的位置
                }
            }

            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != minIndex) {  //交换a[i]和a[minIndex]
                swap(arr, i, minIndex);
            }

        }
    }

    //完成数组两元素间交换
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
