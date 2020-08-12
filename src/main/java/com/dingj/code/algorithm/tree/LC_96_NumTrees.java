package com.dingj.code.algorithm.tree;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class LC_96_NumTrees {

    /**
     * 假设n个节点存在二叉搜索树的个数是g(n)，令f(i)为以i为根的二叉搜索树的个数，则
     * g(n) = f(1) + f(2) + ... + f(n)
     * 当i为根节点时，左子树个数为i-1,即左子树可组合 g(i-1)个，右子树个数为n-i,即可组合g(n-i)，结合上面公式，
     * f(i) = g(i-1) * g(n-i)
     * 综合两个公式，卡特兰数 公式
     * g(n) = g(0) * g(n-1) + g(1) * g(n-2) + ... + g(n-1) * g(0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
