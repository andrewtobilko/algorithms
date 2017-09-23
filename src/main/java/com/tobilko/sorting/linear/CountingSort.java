package com.tobilko.sorting.linear;

import java.util.Arrays;

/**
 * INPUT: integers in the range 0 to k, k = O(n) -> Θ(n).
 * <p>
 * For each x, counts the number of elements less than x.
 * <p>
 * A[0, n] - the input
 * B[0, n] - the output
 * C[0, k] - the temporary working storage
 * <p>
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
        for (int i = 1; i < K; C[i] += C[i - 1], ++i) ;

        // place an A[i] into its correct sorted position in the B
        for (int i = n - 1; i >= 0; B[C[A[i]] - 1] = A[i], --C[A[i]], --i) ;

        return B;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 2, 4, 7, 6, 5, 5, 4, 2, 5, 8, 9, 8, 7, 2};
        int[] output = sort(input);

        System.out.println("> " + Arrays.toString(input));
        System.out.println("< " + Arrays.toString(output));
    }

}
