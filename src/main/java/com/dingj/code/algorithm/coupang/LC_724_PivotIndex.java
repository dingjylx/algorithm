package com.dingj.code.algorithm.coupang;

/**
 * 724. 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * <p>
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_724_PivotIndex {

    /**
     * 前缀和
     * 动态计算leftsum，如果 leftsum = sum - leftsunm -nums[i]， i就是中心索引
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int n : nums) {
            sum += n;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }
}
