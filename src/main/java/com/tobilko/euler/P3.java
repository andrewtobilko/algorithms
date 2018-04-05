package com.tobilko.euler;

/**
 * Created by Andrew Tobilko on 3/30/18.
 */
public class P3 {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();

        long n = 600851475143L;

        long a = n;
        long divisor = 2;
        while (a != 1) {
            if (a % divisor == 0) {
                a = a / divisor;
            } else {
                ++divisor;
            }
        }

        System.out.println(divisor + " " + (System.currentTimeMillis() - t));

    }

}
