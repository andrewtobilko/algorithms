package com.tobilko.euler;

/**
 * Created by Andrew Tobilko on 4/5/18.
 */
public class P9 {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();

        int s = 1000;

        for (int a = 1; a < s; a++) {
            for (int b = 1; b < s; b++) {
                int c = s - a - b;
                if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
                    System.out.println(a * b * c);
                    return;
                }
            }
        }


    }

}
