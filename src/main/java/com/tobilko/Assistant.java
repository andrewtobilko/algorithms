package com.tobilko;

import java.util.Arrays;
import java.util.Random;

/**
 * Describes auxiliary methods for working with algorithms.
 */
public class Assistant {

    /**
     * Displays {@code array} on a standard output stream.
     *
     * @param array the array that will be displayed
     * @param <T> the parameter is responsible for array type
     */
    public static <T extends Comparable<T>> void show(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * It is responsible for swapping two elements in the specified array.
     *
     * @param array provides references to its elements for exchanging them
     * @param i the position of array that will be replaced by an element with {@code j} position
     * @param j the position of array that will be replaced by an element with {@code i} position
     * @param <T> the parameter is responsible for array type
     */
    public static <T extends Comparable<T>> void exchange(T[] array, int i, int j) {
        T temporary = array[j];
        array[j] = array[i];
        array[i] = temporary;
    }

    /**
     * Checks whether array is an ordered array.
     *
     * @param array the array that will be checked
     * @param <T> the parameter is responsible for array type
     * @return  {@code true} if an array is sorted, otherwise returns {@code false}
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; ++i) {
            if (greater(array[i], array[i + 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a result of comparison two elements.
     *
     * @param i the element for comparison
     * @param j the element for comparison
     * @param <T> represents elements type
     *
     * @return {@code true} if {@code i} element is less than {@code j} element.
     *         Otherwise, returns {@code false}.
     */
    public static <T extends Comparable<T>> boolean less(T i, T j) {
        return i.compareTo(j) < 0;
    }

    /**
     * Returns a result of comparison two elements.
     *
     * @param i the element for comparison
     * @param j the element for comparison
     * @param <T> represents elements type
     *
     * @return {@code true} if {@code i} element is greater than {@code j} element.
     *         Otherwise, returns {@code false}.
     */
    public static <T extends Comparable<T>> boolean greater(T i, T j) {
        return i.compareTo(j) > 0;
    }

    /**
     *
     *
     * @param size the length of generated array
     * @param min the minimal element that may be contained in array
     * @param max the maximal element that may be contained in array
     *
     * @return new {@code Integer[]} array
     */
    public static Integer[] generate(long size, int min, int max) {
        return Arrays.stream(new Random().ints(size, min, max + 1).toArray())
                .boxed().toArray(Integer[]::new);
    }
}
