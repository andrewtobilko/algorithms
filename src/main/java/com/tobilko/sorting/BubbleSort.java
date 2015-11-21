package com.tobilko.sorting;

import static com.tobilko.Assistant.exchange;
import static com.tobilko.Assistant.greater;

/**
 * Worst case performance: O(n<sup>2</sup>)
 * Average case performance: O(n<sup>2</sup>)
 * Best case performance: O(n)
 *
 * @author Andrew Tobilko
 */
public class BubbleSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < length - 1; ++i) {
                if (greater(array[i], array[i + 1])) {
                    exchange(array, i, i + 1);
                    isSorted = false;
                }
            }
        }
    }
}
