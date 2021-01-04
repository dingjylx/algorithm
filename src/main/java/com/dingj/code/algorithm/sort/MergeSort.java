package com.dingj.code.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * 1、分解: 将n 个元素分成含 n/ 2 个元素的子序列
 * 2、解决: 对两个子序列递归地进行排序
 * 3、合并: 合并两个已排序的子序列得到排序结果
 *
 * 稳定性排序
 * 最好最坏时间复杂度：O(nlogn)
 * 需要辅助数组，空间复杂度为O(n)
 *
 *
 * java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。
 */
public class MergeSort {

    private static void mergeSort(int[] nums, int[] tmp, int left, int right){
        if(left < right){
            // 二分将数组拆分两半
            int mid = (left + right) >> 1;
            mergeSort(nums,tmp,left,mid);//左边归并排序，使得左子序列有序
            mergeSort(nums,tmp,mid + 1,right);//右边归并排序，使得右子序列有序
            // 将两个数组重新合并
            merge(nums,tmp,left,right,mid);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] nums,int[] tmp, int left, int right, int mid){
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针

        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                tmp[t++] = nums[i++];
            } else {
                tmp[t++] = nums[j++];
            }
        }

        while(i <= mid){//将左边剩余元素填充进tmp中
            tmp[t++] = nums[i++];
        }

        while(j <= right){//将右序列剩余元素填充进tmp中
            tmp[t++] = nums[j++];
        }

        t = 0;
        //将tmp中的元素全部拷贝到原数组中
        while(left <= right){
            nums[left++] = tmp[t++];
        }

    }

    public static void main(String[] args) {
        int[] nums = {11,44,23,67,88,65,34,48,9,12};
        int[] tmp = new int[nums.length];    //新建一个临时数组存放
        mergeSort(nums,tmp,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
