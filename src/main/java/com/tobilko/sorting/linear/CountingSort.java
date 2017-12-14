package com.tobilko.sorting.linear;

import java.util.Arrays;

/**
 * Created by Andrew Tobilko on 9/20/17.
 */
public final class CountingSort {

    private final static int K = 10;

    public static int[] sort(int[] A) {

        // initialise some stuff
        int n = A.length;

        int B[] = new int[n];
        int C[] = new int[K];

        // count the number of occurrences an array[i] and save into a C[array[i]]
        for (int i = 0; i < n; ++C[A[i]], ++i) ;

        // count the number of elements that less than or equal to i
        for (int i = 1; i < K; C[i] += C[i - 1], ++i);

        // place an A[i] into its correct sorted position in the B
        for (int i = n - 1; i >= 0; B[C[A[i]] - 1] = A[i], --C[A[i]], --i) ;

        return B;
    }

}
