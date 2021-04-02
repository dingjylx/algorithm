package com.dingj.code.algorithm.string;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.18. 最短超串
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * <p>
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-supersequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_FACE_1718_ShortestSeq {


    /**
     * 解法：map
     * 1、将small数组中的数存在map中，其value初始化为-1
     * 2、遍历big数组，map存储small数组中每一个值在big数组中的位置，并更新
     * 3、当在big数组中找齐了所有在small数组中的数字后，就用当前下标i减去map中value的最小值（即位置的最小值），得到的差即为“包含短数组所有的元素的子数组长度”
     * 4、时间复杂度为O(nm)
     *
     * @param big
     * @param small
     * @return
     */
    public int[] shortestSeq(int[] big, int[] small) {

        if (small.length > big.length) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = small.length;
        int[] ans = {0, big.length};

        for (int i : small) {
            map.put(i, -1);// key存small数组，value为期在big中的位置
        }

        for (int i = 0; i < big.length; i++) {
            if (map.containsKey(big[i])) {
                if (map.get(big[i]) == -1) {
                    count--;
                }
                map.put(big[i], i);
            }

            if (count <= 0) {
                Collection<Integer> c = map.values();
                Object[] obj = c.toArray();
                int minNum = getMin(obj);
                if (i - minNum + 1 < ans[1] - ans[0] + 1) {
                    ans[0] = minNum;
                    ans[1] = i;
                }
            }
        }

        if (count > 0) {
            return new int[0];
        }

        return ans;

    }

    int getMin(Object[] obj) {
        int minNUm = Integer.MAX_VALUE;
        for (Object o : obj) {
            minNUm = Math.min((int) o, minNUm);
        }
        return minNUm;
    }

}
