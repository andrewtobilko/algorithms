package com.tobilko.euler;

/**
 * Created by Andrew Tobilko on 4/5/18.
 */
public class P4 {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        int min = 100;
        int max = 999;
        int result = 0;

        for (int i = min; i < max; ++i) {
            for (int j = min; j < max; ++j) {
                final int m = i * j;

                if (isPalindromic(Integer.toString(m)) && result < m) {
                    result = m;
                }
            }
        }

        System.out.println(result);
        System.out.println((System.currentTimeMillis() - t) / 1e3);
    }

    private static boolean isPalindromic(String s) {
        final int l = s.length();

        for (int i = 0; i < l / 2; i++) {
            char lC = s.charAt(i);
            char rC = s.charAt(l - i - 1);

            if (lC != rC) {
                return false;
            }
        }

        return true;
    }

}
