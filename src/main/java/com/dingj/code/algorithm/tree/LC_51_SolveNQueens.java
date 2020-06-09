package com.dingj.code.algorithm.tree;

import java.util.*;

/**
 * N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class LC_51_SolveNQueens {

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    /**
     * 思考路径：
     * 1. 定位这是backtrack problem
     * 2. 思考决策树的构建过程
     * 3. 思考回溯的模板
     */
    // 决策树的每一层表示棋盘上的每一行；每个节点可以做出的选择是，在该行的任意一列放置一个皇后。
    static class Solution1 {
        List<List<String>> res;

        public List<List<String>> solveNQueens(int n) {
            if (n <= 0) return null;
            res = new LinkedList<>();
            char[][] board = new char[n][n];
            for (char[] chars : board) {
                Arrays.fill(chars, '.');
            }
            backtrack(board, 0);
            return res;
        }

        /**
         * 路径：board中小于row的那些行都已经成功放置了皇后
         * 可选择列表: 第row行的所有列都是放置Q的选择
         * 结束条件: row超过board的最后一行
         *
         * @param board
         * @param row
         */
        private void backtrack(char[][] board, int row) {
            // 约束条件
            if (row == board.length) {
                res.add(charToString(board));
                return;
            }
            // 选择列表:第row行的所有列都是放置Q的选择
            int n = board[row].length;
            for (int col = 0; col < n; col++) {
                if (!isValid(board, row, col)) continue;
                // 做选择
                board[row][col] = 'Q';
                // 下一行
                backtrack(board, row + 1);
                // 撤销选择
                board[row][col] = '.';

            }

        }

        /**
         * 是否可以在 board[row][col] 放置皇后
         *
         * @param board
         * @param row
         * @param col
         * @return
         */
        private boolean isValid(char[][] board, int row, int col) {
            int rows = board.length;
            // 检测列是否有皇后互相冲突
            for (char[] chars : board) {
                if ('Q' == chars[col]) return false;
            }
            // 检测右上方是否有皇后互相冲突
            for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
                if ('Q' == board[i][j]) return false;
            }
            // 检测左上方是否有皇后互相冲突
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if ('Q' == board[i][j]) return false;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        for(int i=3,j=3;i>=0 && j>=0;i--,j--){
            System.out.println(i + "-" + j);
        }
    }


}
