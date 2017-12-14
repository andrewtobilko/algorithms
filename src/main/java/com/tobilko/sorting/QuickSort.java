package com.tobilko.sorting;

import static com.tobilko.Assistant.swap;

/**
 * Created by Andrew Tobilko on 12/8/17.
 */
public final class QuickSort {

    public void sort(int[] A, int p, int r) {
        if (p < r) {
            final int q = applyDefaultPartitionSchema(A, p, r);
            sort(A, p, q - 1);
            sort(A, q + 1, r);
        }
    }

    private int applyDefaultPartitionSchema(int[] A, int p, int r) {
        final int pivot = A[r];
        int i = p - 1;

        for (int j = p; j < r - 1; ++j) {
            if (A[j] <= pivot) {
                swap(A, ++i, j);
            }
        }

        ++i;
        swap(A, i, r);

        return i;
    }

    private int applyHoarePartitionSchema(int[] array, int p, int r) {
        final int pivot = array[p];

        int l = p - 1;
        int u = r + 1;

        while (true) {
            do {
                ++l;
            } while (pivot > array[l]);

            do {
                --u;
            } while (pivot < array[u]);

            if (l >= u) {
                return u;
            }

            swap(array, l, u);
        }

    }

    private int applyLomutoPartitionSchema(int[] array, int lowerIndex, int upperIndex) {
        int pivot = array[upperIndex];

        return 0;
    }


}
