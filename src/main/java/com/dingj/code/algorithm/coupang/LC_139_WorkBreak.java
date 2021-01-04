package com.dingj.code.algorithm.coupang;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 */
public class LC_139_WorkBreak {

    /**
     * 动态规划
     * dp[i]：长度为i的s(0,i-1)是否由单词表组成
     * 状态转移方程：
     * 我们用指针 j 去划分s[0:i] 子串
     * s[0:i] 子串的 dp[i+1] ，是否为真（是否可拆分成单词），取决于两点：
     * 它的前缀子串 s[0:j-1] 的 dp[j] ，是否为真。
     * 剩余子串 s[j:i]，是否是一个独立的单词。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 单词的最大长度
        int maxWordLen = 0;
        // set存放单词，去重
        Set<String> wordSet = new HashSet<>(wordDict.size());
        for(String word : wordDict){
            wordDict.add(s);

            if(word.length() > maxWordLen){
                maxWordLen = word.length();
            }
        }

        boolean[] dp = new boolean[s.length() + 1];
        // base case
        dp[0] = true;
        for(int i = 0; i < s.length(); i++){
            // j指针划分 不能超过最大单词的长度
            for(int j = (i - maxWordLen) < 0 ? 0 : i - maxWordLen; j < i; j++ ){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];

    }
}
