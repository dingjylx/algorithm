package com.dingj.code.algorithm.other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 */
public class LC_179_LargestNumber {

    private class LargestNumberComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(asStrs, new LargestNumberComparator());

        if (asStrs[0].equals("0")) {
            return "0";
        }

        String largestNumberStr = "";
        for (String s : asStrs) {
            largestNumberStr += s;
        }
        return largestNumberStr;
    }

    public static void main(String[] args) {
        LC_179_LargestNumber lc_179_largestNumber = new LC_179_LargestNumber();
        System.out.println(lc_179_largestNumber.largestNumber(new int[]{123, 76, 7, 9}));
    }


}
