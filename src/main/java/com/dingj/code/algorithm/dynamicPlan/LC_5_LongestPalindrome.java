package com.dingj.code.algorithm.dynamicPlan;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LC_5_LongestPalindrome {

    /**
     * 动态规划
     * 用 P(i,j) 表示字符串 s的第 i 到 j个字母组成的串（下文表示成 s[i:j]）是否为回文串
     * 状态转移方程：
     * dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
     * 说明：
     * 「动态规划」事实上是在填一张二维表格，由于构成子串，因此 i 和 j 的关系是 i <= j ，因此，只需要填这张表格对角线以上的部分。
     *  看到 dp[i + 1][j - 1] 就得考虑边界情况。
     *
     *  边界条件是：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArr = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {// i肯定小于j 才能构成子串
                if (charArr[i] != charArr[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要一得到 dp[i][j] = true，就记录子串的长度和起始位置，没有必要截取，
                // 这是因为截取字符串也要消耗性能，记录此时的回文子串的「起始位置」和「回文长度」即可。

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
