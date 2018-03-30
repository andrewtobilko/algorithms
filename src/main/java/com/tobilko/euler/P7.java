package com.tobilko.euler;

/**
 * Created by Andrew Tobilko on 3/30/18.
 */
public class P7 {
    public static void main(String[] args) {
        long lastPrimeNumber = 0;
        long lastPrimeNumberIndex = 0;

        for (int i = 2; lastPrimeNumberIndex != 100_001 + 1; i++) {
            if (isPrime(i)) {
                ++lastPrimeNumberIndex;
                lastPrimeNumber = i;
            }
        }

        System.out.println(lastPrimeNumber);
    }

    private static boolean isPrime(int i) {
        if (i < 2) {
            return false;
        }
        if (i == 2 || i == 3) {
            return true;
        }
        if (i % 2 == 0) {
            return false;
        }
        for (int j = 5; j < i - 1; j += 2) {
            if (i % j == 0) {
                return false;
            }
        }

        return true;

    }
}
