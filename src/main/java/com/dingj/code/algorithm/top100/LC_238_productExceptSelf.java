package com.dingj.code.algorithm.top100;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_238_productExceptSelf {

    /**
     * 乘积 = 当前数左边的乘积 * 当前数右边的乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums){
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0 ; i < res.length; i++){
            res[i] = k;
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }

        k = 1;
        for(int i = res.length - 1; i >=0 ; i--){
            res[i] = res[i] * k; // k为该数右边的乘积。
            k = k * nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }
}
