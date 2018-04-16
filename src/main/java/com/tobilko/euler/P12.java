package com.tobilko.euler;

/**
 * Created by Andrew Tobilko on 4/16/18.
 */
public class P12 {
    public static void main(String[] args) {
        System.out.println(hmd(66));
    }

    static int hmd(long n) {
        int s = 1;
        for (long i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                ++s;
            }
        }

        return s;
    }
}
