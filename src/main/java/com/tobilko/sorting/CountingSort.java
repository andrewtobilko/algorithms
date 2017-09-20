package com.tobilko.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Andrew Tobilko on 9/20/17.
 */
public final class CountingSort {

    private final static int K = 100;

    public static void sort(int[] array) {

        System.out.println("> " + Arrays.toString(array));

        int A = array.length;

        int B[] = new int[A];
        int C[] = new int[K];

        for (int i = 0; i < A; i++) {
            C[array[i]] = C[array[i]] + 1;
        }

        System.out.println();



        System.out.println("< " + Arrays.toString(B));
    }

    public static void main(String[] args) {
        sort(new Random().ints().limit(10).filter(i -> i < K).toArray());
    }

}
