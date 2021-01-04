package com.dingj.code.algorithm.top100;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_1_TwoSum {

    public int[] twoSum(int[] nums, int target){
        // hashmap O(n) ，整数，整数在数组的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{i,map.get(nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

}
