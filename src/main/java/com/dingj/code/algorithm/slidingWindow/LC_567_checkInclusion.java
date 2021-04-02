package com.dingj.code.algorithm.slidingWindow;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 */
public class LC_567_checkInclusion {

    /**
     * 因为s1的字母的顺序不要求，所以判断是s2的子串只要，字母的个数相同即可，所以用滑动窗口求解！
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        // 如果字符串为空，或者长度小于需要匹配的长度
        if (s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }
        // 统计所需字符及其个数
        int[] need = new int[128];
        // 统计当前窗口中的字符及其个数
        int[] window = new int[128];

        for(int i = 0; i < s1.length(); i++){
            need[s1.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        while(right < s2.length()){
            // 进入窗口的字符
            char c = s2.charAt(right);
            // 扩大窗口
            right ++;
            // 如果进入的字符是需要的字符
            if(need[c] > 0){
                // 修改窗口字符记录
                window[c]++;
            }

            // 当窗口子串长度大于等于s1的长度的时候开始收缩窗口（排列长度一致）
            while(right - left >= s1.length()){
                //判断两个数组内容相等，注意，不能用 "=="，那玩意比较的是地址
                if(Arrays.equals(need,window)){
                    return true;
                }
                // 离开窗口的字符
                char d = s2.charAt(left);
                // 收缩窗口
                left++;
                // 如果离开窗口的字符是需要的字符
                if(need[d] > 0){
                    // 修改窗口记录
                    window[d]--;
                }
            }
        }
        // 没找到符合条件的子串
        return false;
    }

    public static void main(String[] args) {
        boolean b = checkInclusion("abcxadbe","abcbdax");
        System.out.printf(String.valueOf(b));
    }
}
