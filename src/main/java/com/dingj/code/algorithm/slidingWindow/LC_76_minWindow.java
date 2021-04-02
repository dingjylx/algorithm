package com.dingj.code.algorithm.slidingWindow;

/**
 * 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_76_minWindow {

    /**
     * 滑动窗口
     * 整型数组存放 Char， Char 的 int 值范围为 0 ~ 127
     *
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        // 如果字符串为空，或者长度小于需要匹配的长度
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        //用来统计t中每个字符出现次数
        int[] need = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;// char型可以转换成0-128的int，对应字符的ASCII码
        }

        int left = 0;
        int right = 0;

        //窗口目前已覆盖t中多少个字符
        int count = 0;

        //用来记录最短需要多少个字符。
        int minLength = s.length() + 1;

        String res = "";

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            /** needs[ch] > 0 表示 ch 在 t 中，
                needs[ch] >= window[ch] 表示窗口中 ch 出现的次数没有超出 ch 在 t 中出现的次数，
                所以整个if条件就是用来表示 匹配了字符 ch ，并且匹配 ch 的次数没有超出 ch 在 t 中出现的次数。
                比如 s="AAAC"，t="AC"，右指针右移时，
                    第一个 A，count = 1，
                    第二 A 时，needs[A]=1 , window[A]=2，不符合条件，count 不变，第三个 A 同理。
                    进入内循环时，左指针右移过程中，
                        window[A] 递减， 一直到左指针指向第三个A时，needs[ch] >= window[ch] 条件才满足，count--，结束内循环。
             **/

            // 如果需要该字符，并且已有窗口内的字符个数小于需要的字符个数
            if (need[ch] > 0 && need[ch] >= window[ch]) {
                count++;
            }

            // 当需要的字符都已经包含在窗口中后，开始收缩 left
            while (count == t.length()) {
                ch = s.charAt(left);

                // 当需要删除的字符，是必须留在窗口内时
                if (need[ch] > 0 && need[ch] >= window[ch]) {
                    count--;
                }
                // 这边需要取 = ，因为可能一开始两个字符串就是匹配的，如 a , a return a
                if (right - left + 1 <= minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                window[ch]--;
                left++;
            }

            right++;
        }

        return res;


    }
}
