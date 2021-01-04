package com.dingj.code.algorithm.coupang;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 */
public class LC_415_AddStrings {

    public String addStrings(String num1, String num2){
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;// 是否需要进1
        StringBuilder res = new StringBuilder("");
        while( i >= 0 || j >= 0){
            int n1 = i >=0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >=0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            res.append(tmp % 10);
            carry = tmp / 10;
            i--;
            j--;
        }
        // 最后判断是否需要在前面补1
        if(carry == 1){
            res.append(1);
        }
        return res.reverse().toString();
    }




    public static void main(String[] args) {
        System.out.println('8'+'2');

    }
}
