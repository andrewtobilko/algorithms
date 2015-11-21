package com.tobilko.sorting;

import static com.tobilko.Assistant.less;
import static com.tobilko.Assistant.exchange;

/**
 * Worst case performance: O(n<sup>2</sup>)
 * Average case performance: O(n<sup>2</sup>)
 * Best case performance: O(n)
 *
 * @author Andrew Tobilko
 */
public class InsertionSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exchange(array, j, j - 1);
            }
        }
    }
}
