package com.dingj.code.algorithm.array;


/**
 * 55. 跳跃游戏
 */
public class LC_55_CanJump {

    /**
     * 正序贪心：
     * 在遍历的过程中，如果 最远可以到达的位置 大于等于数组中的最后一个位置，那就说明最后一个位置可达，我们就可以直接返回 True 作为答案。
     * 反之，如果在遍历结束后，最后一个位置仍然不可达，我们就返回 False 作为答案。
     * 始终维护从起始点出发可以达到的最远坐标
     * 当最远坐标大于等于最后一个位置，则可到达
     *
     * @param nums
     * @return
     */
    public boolean jump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int n = nums.length;
        int maxDist = 0;// 设定可以达到的最大坐标
        for (int i = 0; i < n; i++) {
            // 表示当前坐标可以达到
            if (i <= maxDist)
                // 更新可以达到的最远坐标
                maxDist = Math.max(maxDist, nums[i] + i);
        }
        return maxDist >= n - 1;

    }

    /**
     * 倒序
     * 我们用一个变量pos来表示需要到达的位置，并初始化为nums.length - 1表示需要到达的位置为最后一个位置。
     * 然后从nums.length - 2向前遍历，if(nums[i] + i >= pos)表示从当前位置出发能够到达pos，因此只要能到达当前位置i就可以到达pos，因此可以更新pos为i的值。
     * 遍历到最后如果pos==0，也就表示从开始能够跳到末尾。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        // 要到达的位置
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            // 可以到达，更新
            if (i + nums[i] >= pos) pos = i;
        }
        return pos == 0;
    }

}
