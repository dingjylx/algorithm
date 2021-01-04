package com.dingj.code.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序（交换排序）
 * 分治思想
 * 找一个基准数（一般数组第一个,优化：取随机数），遍历数组，采用双指针法，从数组的两端分别进行比对，
 * 将小于基准数的放置于基准数左边，大于基准数的放置于基准数右边。
 * 然后利用递归算法，对分治后的两个子数组进行排序。
 * <p>
 * 快速排序之所以比较快，
 * 是因为相比冒泡排序，每次的交换都是跳跃式的，每次设置一个基准值，将小于基准值的都交换到左边，大于基准值的都交换到右边，
 * 这样不会像冒泡一样每次都只交换相邻的两个数，因此比较和交换的此数都变少了，速度自然更高。
 * 当然，也有可能出现最坏的情况，就是仍可能相邻的两个数进行交换。
 * <p>
 *
 * 不稳定
 * 平均复杂度很容易计算得到为O(NlogN)
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        int len;
        if (array == null || (len = array.length) <= 1) {
            return;
        }
        sort(array, 0, len - 1);
    }

    public static void sort(int[] array, int left, int right) {
        if (left > right)
            return;
        int base = array[left];// base存放基准数
        int i = left;// 左边哨兵的索引
        int j = right;// 右边哨兵的索引
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);

    }

    public static void main(String[] args) {
        int[] nums = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
