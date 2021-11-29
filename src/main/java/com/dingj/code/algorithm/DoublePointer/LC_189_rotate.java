package com.dingj.code.algorithm.DoublePointer;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class LC_189_rotate {

    /**
     * 数组翻转
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;//k可能比数组大，在这种情况下，向右移动整个数组长度后就回到原来的位置，直接%掉就是去掉每次回到原来位置的步数，获得最后移动的步数
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
