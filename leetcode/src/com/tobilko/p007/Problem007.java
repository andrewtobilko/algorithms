package com.tobilko.p007;

import static java.lang.Integer.valueOf;

public class Problem007 {

    public static void main(String[] args) {
        System.out.println(new Problem007().reverse(123));
    }

    public int reverse(int x) {
        boolean negativeNumber = x < 0;
        try {
            return (negativeNumber ? -1 : 1) * valueOf(new StringBuilder(Integer.toString(x).replace("-", "")).reverse().toString());
        } catch (NumberFormatException exception) {
            return 0;
        }
    }

}