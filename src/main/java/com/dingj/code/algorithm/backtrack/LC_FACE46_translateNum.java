package com.dingj.code.algorithm.backtrack;

import java.util.HashMap;

public class LC_FACE46_translateNum {

    String result = "";
    private HashMap<Integer, String> map;

    public int translateNum(int num) {

        return 0;
    }

    private void backtrack(int[] nums, boolean[] visited, StringBuilder rs) {
        int sz = nums.length - 1;
        // 结束条件
        if (visited[sz]) {
            result = rs.toString();
            return;
        }

        // 做选择
        for (int i = 0; i <= sz; i++) {
            // 已经访问过，不再选择
            if (visited[i]) continue;
            rs.append(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, rs);
            visited[i] = false;

        }

    }

}
