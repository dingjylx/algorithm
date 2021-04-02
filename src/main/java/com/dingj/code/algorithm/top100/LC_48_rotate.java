package com.dingj.code.algorithm.top100;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_48_rotate {
    /**
     * 辅助数组
     * 规律：对于矩阵中第 i 行的第 j个元素，在旋转后，它出现在倒数第 i 列的第 j 个位置。
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix_new[j][n-i-1] = matrix[i][j];
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = matrix_new[i][j];
            }
        }

    }
}
