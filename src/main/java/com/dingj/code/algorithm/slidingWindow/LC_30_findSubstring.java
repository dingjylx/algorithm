package com.dingj.code.algorithm.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_30_findSubstring {


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }
        for (String word : words) {
            // 主串s没有这个单词，直接返回空
            if (s.indexOf(word) < 0) {
                return res;
            }
            // map保存每个单词和出现的次数
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 每个单词的长度
        int oneLen = words[0].length();
        // 总长度
        int allLen = oneLen * words.length;
        // 主串s长度小于单词总和，返回空
        if (s.length() < allLen) {
            return res;
        }
        // 只讨论从0，1，...， oneLen-1 开始的子串情况，
        // 每次进行匹配的窗口大小为 wordsLen，每次后移一个单词长度，由左右窗口维持当前窗口位置
        for (int i = 0; i < oneLen; i++) {
            // 左右窗口
            int left = i, right = i, count = 0;
            // 统计每个符合要求的word
            Map<String, Integer> subMap = new HashMap<>();
            // 右窗口不能超过主串长度
            while (right + oneLen <= s.length()) {
                // 得到一个单词
                String word = s.substring(right, right + oneLen);
                // 有窗口右移
                right += oneLen;
                // words[]中没有这个单词，那么当前窗口肯定匹配失败，直接右移到这个单词后面
                if (!map.containsKey(word)) {
                    left = right;
                    // 窗口内单词统计清空，重新统计
                    subMap.clear();
                    // 符合要求的单词数，清0
                    count = 0;
                } else {
                    // 统计当前子串中这个单词出现的次数
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    count++;
                    // 如果这个单词出现的次数大于words[]中它对应的次数，又由于每次匹配和words长度相等的子串，滑动左窗口
                    while (subMap.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
                        // 从当前窗口字符统计map中删除从左窗口开始到数量超限的所有单词(次数减一)
                        String w = s.substring(left, left + oneLen);
                        subMap.put(w, subMap.getOrDefault(w, 0) - 1);
                        count--;
                        left += oneLen;
                    }
                    // 当前窗口字符串满足要求
                    if (count == words.length) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}
