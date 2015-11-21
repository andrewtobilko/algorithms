package com.tobilko.sorting;

import static com.tobilko.Assistant.exchange;
import static com.tobilko.Assistant.less;

/**
 * Worst case performance: O(n<sup>2</sup>)
 * Average case performance: O(n<sup>2</sup>)
 * Best case performance: O(n<sup>2</sup>)
 *
 * @author Andrew Tobilko
 */
public class SelectionSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            if (min != i) {
                exchange(array, i, min);
            }
        }
    }
}
