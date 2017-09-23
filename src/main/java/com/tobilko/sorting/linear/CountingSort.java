package com.tobilko.sorting.linear;

import java.util.Arrays;

/**
 *
 * INPUT: integers in the range 0 to k, k = O(n) -> Θ(n).
 *
 * For each x, counts the number of elements less than x.
 *
 *
 * Created by Andrew Tobilko on 9/20/17.
 */
public final class CountingSort {

    public static void sort(int[] array) {

        System.out.println("> " + Arrays.toString(array));

        int A = array.length;

        int B[] = new int[A];
        int C[] = new int[100];

        for (int i = 0; i < A; i++) {
            C[array[i]] = C[array[i]] + 1;
        }

        System.out.println();



        System.out.println("< " + Arrays.toString(B));
    }

    public static void main(String[] args) {
        sort(new int[] {23, 2, 4, 12, 13, 11, 34, 32, 45, 100, 23, 34, 76, 53, 98});
    }

}
