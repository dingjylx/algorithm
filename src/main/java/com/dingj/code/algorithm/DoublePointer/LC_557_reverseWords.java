package com.dingj.code.algorithm.DoublePointer;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class LC_557_reverseWords {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < strings.length; i++){
            sb.append(reverseString(strings[i]));
            if(i < strings.length - 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseString(String str) {
        char[] s = str.toCharArray();
        int left = 0;
        int right = s.length - 1;
        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return new String(s);
    }

    /**
     * 1、通过split(" ")来分割字符串得到单词数组；
     * 2、利用StringBuffer里的reverse()函数完成单词翻转；
     * 3、依次累加
     * @param s
     * @return
     */
    public String reverseWords2(String s){
        String[] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length; i++){
            sb.append(" ").append(new StringBuffer(str[i]).reverse());
        }
        sb.delete(0,1);
        return sb.toString();
    }
}
