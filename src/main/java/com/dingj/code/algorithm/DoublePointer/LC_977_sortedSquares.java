package com.dingj.code.algorithm.DoublePointer;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 */
public class LC_977_sortedSquares {

    public int[] sortedSquares(int[] nums) {
        int size = nums.length;
        int k = size - 1;
        int[] result = new int[size];
        for(int i = 0, j = size -1; i <= j;){
            if(nums[i] * nums[i] < nums[j] * nums[j]){
                result[k--] = nums[j] * nums[j];
                j--;
            } else {
                result[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return result;
    }
}
