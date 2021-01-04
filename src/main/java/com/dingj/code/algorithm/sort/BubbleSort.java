package com.dingj.code.algorithm.sort;

/**
 * 冒泡排序（交换排序）
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * 稳定
 * 时间复杂度O(n2)
 */
public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {//注意第二重循环的条件
                if (nums[j] > nums[j + 1]) {//交换两数位置
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

}
