package com.tobilko.sorting;

/**
 *
 * Created by Andrew Tobilko on 12/8/17.
 */
public final class QuickSort {

    public void sort(int[] array, int lowerIndex, int upperIndex) {
        if (lowerIndex < upperIndex) {
            int pivot = partition(array, lowerIndex, upperIndex);
            sort(array, lowerIndex, pivot - 1);
            sort(array, pivot + 1, upperIndex);
        }
    }

    private int partition(int[] array, int lowerIndex, int upperIndex) {
        return applyHoarePartitionSchema(array, lowerIndex, upperIndex);
    }

    private int applyHoarePartitionSchema(int[] array, int lowerIndex, int upperIndex) {
        int pivot = array[lowerIndex];

        int l = lowerIndex - 1;
        int u = upperIndex + 1;

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

            swapArrayElementsByIndices(array, l, u);
        }

    }

    private int applyLomutoPartitionSchema(int[] array, int lowerIndex, int upperIndex) {
        int pivot = array[upperIndex];

        return 0;
    }

    private void swapArrayElementsByIndices(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}