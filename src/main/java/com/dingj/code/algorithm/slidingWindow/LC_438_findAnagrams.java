package com.dingj.code.algorithm.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * 给定一个字符串s和一个非空字符串p，找到s中所有是p的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串s和 p的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_438_findAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {

        int[] need = new int[128];
        int[] window = new int[128];

        for(int i = 0 ; i < p.length(); i++){
            need[p.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        List<Integer> resList = new ArrayList<>();

        while(right < s.length()){
            char ch = s.charAt(right);
            right++;
            window[ch]++;

            // 排列长度一致，收缩左窗口
            while (right - left >= p.length()){
                // 判断是否满足条件
                if(Arrays.equals(need, window)){
                    resList.add(left);
                }
                ch = s.charAt(left);
                left++;
                window[ch]--;
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        List<Integer> res = findAnagrams("cbaebabacd","abc");
        System.out.printf(res.toString());
    }


}
