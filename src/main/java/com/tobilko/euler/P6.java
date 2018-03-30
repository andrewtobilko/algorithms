package com.tobilko.euler;

/**
 * Created by Andrew Tobilko on 3/30/18.
 */
public class P6 {
    public static void main(String[] args) {
        int firstN = 100;
        System.out.println(resolveProblem(getSumSquare(firstN), getSquareSum(firstN)));
    }

    private static long getSumSquare(int firstN) {
        long sum = 0;
        for (int i = 1; i <= firstN; i++) {
            sum += Math.pow(i, 2);
        }

        return sum;
    }

    private static long getSquareSum(int firstN) {
        long sum = 0;
        for (int i = 1; i <= firstN; i++) {
            sum += i;
        }
        return (long) Math.pow(sum, 2);
    }

    private static long resolveProblem(long sumSquare, long quareSum) {
        return quareSum - sumSquare;
    }
}
