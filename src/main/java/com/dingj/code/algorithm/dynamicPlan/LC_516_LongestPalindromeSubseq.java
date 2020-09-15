package com.dingj.code.algorithm.dynamicPlan;

/**
 * 516. 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 */
public class LC_516_LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        // 表示第i个字符到第j个字符组成的串中，最长的回文子串长度是多少
        int[][] dp = new int[n][n];


        // 由下向上遍历，保证每个子问题都有值
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][n - 1];

    }


}
