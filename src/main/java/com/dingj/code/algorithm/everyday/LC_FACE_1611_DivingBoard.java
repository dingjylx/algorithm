package com.dingj.code.algorithm.everyday;

/**
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 */
public class LC_FACE_1611_DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];

        // 当最长和最短相等时，就只有一种
        if (shorter == longer) {
            int result[] = new int[1];
            result[0] = shorter * k;
            return result;
        }

        int result[] = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            result[i] = (k - 1) * shorter + i * longer;
        }
        return result;
    }

}
