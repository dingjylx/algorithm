package com.dingj.code.algorithm.top100;

/**
 * 75.颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class LC_75_sortColors {

    /**
     * 双指针 一次遍历
     * 我们设置 p0 和 p1 两个指针，初始都在索引为 0 处。在程序执行的过程中，p0 左边的数全为 0，p1 与 p0 之间的数全为 1。
     * 如果 nums[i] 为 1，我们只需要交换 nums[i] 与 nums[p1]，并且使 p1++ 即可，不需要牵扯到 p0。
     * 如果 nums[i] 为 0，我们需要先交换 nums[i] 与 nums[p1]，再交换 nums[p1] 与 nums[p0]，
     * 而不能直接交换 nums[i] 与 nums[p0]。这是因为 nums[p0] 很有可能等于 1，直接交换的话会把一个 1 交换出去，会导致错误。
     * 如果我们先交换 nums[i] 与 nums[p1]，就能使得交换后的 nums[p1] = 0，然后交换 nums[p1]（= 0） 与 nums[p0]（= 1），就是 0 和 1 的交换了，就不会有问题。
     * 大家可以用 nums = [2, 0, 2, 1, 1, 0] 这个例子来试一试便知。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // 先交换nums[i]和nums[p1]
                // 再交换nums[p1]和nums[p0]
                swap(nums, i, p1);
                swap(nums, p1, p0);
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                // 只需要交换 num[i] 与 nums[p1]
                swap(nums, i, p1);
                p1++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
