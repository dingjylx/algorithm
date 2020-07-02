package com.dingj.code.algorithm.exception;

public class TrycatchTest {

    public static void add1(int a, int b) {
        try {
            int c = a / b;
        } catch (Exception e) {
            System.out.println("1111111111111111");
        }
    }

    public static void main(String[] args) {
        try {
            add1(2, 0);
        } catch (Exception e) {
            System.out.println("22222222222222222");
        }
    }
}
