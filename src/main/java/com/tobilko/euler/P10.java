package com.tobilko.euler;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Andrew Tobilko on 4/5/18.
 */
public class P10 {
    public static void main(String[] args) {
        final int n = 2_000_000;
        System.out.println(getSumAllPrimesBelowN(n));
    }

    private static long getSumAllPrimesBelowN(int n) {
        final int sqrt = (int)Math.floor(Math.sqrt(n));
        System.out.println("sqrt(n) = " + sqrt);
        boolean[] flags = new boolean[n];

        for (int i = 2; i < sqrt; i++) {
            if (!flags[i]) {
                for (int j = (int)Math.pow(i, 2); j < n; j += i) {
                    flags[j] = true;
                }
            }
        }
        long sum = 0;
        for (int i = 2; i < flags.length; i++) {
            if (!flags[i]) {
                sum += i;
            }
        }
        return sum;
    }
}
