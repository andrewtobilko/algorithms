package com.tobilko.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrew Tobilko on 3/30/18.
 */
public class P7 {
    public static void main(String[] args) {
        long lastPrimeNumber = 0;
        long lastPrimeNumberIndex = 0;

        long t = System.currentTimeMillis();
        for (int i = 1; lastPrimeNumberIndex != 10_001; i += 2) {
            if (isPrime2(i)) {
                ++lastPrimeNumberIndex;
                lastPrimeNumber = i;
            }
        }

        System.out.println(lastPrimeNumber + " " + (System.currentTimeMillis() - t) / 1e3);
    }

    private static boolean isPrime(long i) {
        if (i <= 1) {
            return false;
        }
        if (i < 4) {
            return true;
        }
        if (i % 2 == 0) {
            return false;
        }
        if (i < 9) {
            return true;
        }
        if (i % 3 == 0) {
            return false;
        }

        for (int j = 5; j <= Math.floor(Math.sqrt(i)); j += 6) {
            if (((i % j) == 0) || ((i % (j + 2)) == 0)) {
                return false;
            }
        }

        return true;

    }

    public static boolean isPrime2(long i) {
        if (i <= 1) {
            return false;
        }
        if (i < 4) {
            return true;
        }
        if (i % 2 == 0) {
            return false;
        }
        if (i < 9) {
            return true;
        }
        if (i % 3 == 0) {
            return false;
        }

        for (Long prime : primes) {
            if ((i > prime) && (i % prime == 0)) {
                return false;
            }
        }
        primes.add(i);
        return true;
    }

    private static List<Long> primes = new ArrayList<>(Arrays.asList(2L, 3L, 5L, 7L, 11L));

}
