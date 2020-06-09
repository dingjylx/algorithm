package com.dingj.code.algorithm.BinarySearch;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class LC_FACE_64_SumNums {

    /**
     * 递归
     * 问题： 终止条件需要使用 ifif ，因此本方法不可取。
     * 思考： 除了 ifif 和 switchswitch 等判断语句外，是否有其他方法可用来终止递归？
     * 逻辑运算符的短路效应：
     * 本题需要实现 “当 n = 1n=1 时终止递归” 的需求，可通过短路效应实现。
     * n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归

     */

    int res = 0;
    public int sunNums(int n){
        boolean x = n > 1 && sunNums(n-1) > 0;
        res += n;
        return res;
    }

    public static void main(String[] args) {
        LC_FACE_64_SumNums sumNums = new LC_FACE_64_SumNums();
        System.out.println(sumNums.sunNums(5));
    }
}
