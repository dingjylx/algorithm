package com.dingj.code.algorithm.everyday;


import java.util.Arrays;

/**
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 */
public class LC_378_KthSmallest {


    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int[] array = new int[len * len];
        int n = -1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                array[n + 1] = matrix[i][j];
                n++;
            }
        }
        Arrays.sort(array);
        return array[k - 1];
    }


    /**
     * 二分法
     * 1、初始化left,right代表矩阵的最小值和最大值，即[left,...,right]，数到第k个位置的数组元素
     * 2、取mid= (left+right)/2,即平均值，不一定在矩阵/数组中，没关系，只需统计原矩阵中小于等于mid的个数cnt,
     * 3、如果cnt >= k,缩小范围[left,...,mid]，故right=mid,
     * 如果cnt < k,缩小范围[mid+1,...,right],故left=mid+1,
     * 这样下去，更新left,right，每次都保证第k小元素一定在[left,right]中，当区间缩小到只有一个元素，即left=right，就是第k小元素
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];// 最小数
        int right = matrix[row - 1][col - 1];// 最大数

        // 二分查找
        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = findLessThanMidCnt(matrix, mid, row, col);
            if (cnt >= k)
                right = mid;
            else left = mid + 1;
            mid = (left + right) / 2;
        }
        return right;
    }

    // 查找小于等于mid的元素个数
    public int findLessThanMidCnt(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 5;
        matrix[0][2] = 9;
        matrix[1][0] = 10;
        matrix[1][1] = 11;
        matrix[1][2] = 13;
        matrix[2][0] = 12;
        matrix[2][1] = 13;
        matrix[2][2] = 15;

        LC_378_KthSmallest lc_378_kthSmallest = new LC_378_KthSmallest();
//        lc_378_kthSmallest.kthSmallest(matrix, 8);

        int i = 1;
        int k = 1;
        int cnt = 0;
        while (k < 5) {
            cnt += i + 1;
            k++;
        }

        System.out.println(cnt);

    }


}
