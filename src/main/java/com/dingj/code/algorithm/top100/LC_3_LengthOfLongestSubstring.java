package com.dingj.code.algorithm.top100;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LC_3_LengthOfLongestSubstring {

    /**
     * 滑动窗口，如果遇到重复的，left移动
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;// 不重复子串的最大长度
        int left = 0; // 滑动窗口的左边

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 不走回头路
                left = Math.max(left, map.get(s.charAt(i)));
            }
            // 始终更新i的位置
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
