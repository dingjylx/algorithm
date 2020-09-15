package com.dingj.code.algorithm.dynamicPlan;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class LC_416_CanPartition {

    public boolean canPartition(int[] nums) {

        int len = nums.length;
        if(len == 0){
            return false;
        }

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        // 如果是奇数，不符合要求
        if(sum % 2 == 1){
            return false;
        }

        int target = sum / 2;

        // 创建二维状态数组，行：物品索引，列：容量（包括0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格
        return true;
    }
}
