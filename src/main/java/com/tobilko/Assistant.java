package com.tobilko;

import java.util.Arrays;
import java.util.Random;

public class Assistant {

    public static <T extends Comparable<T>> void show(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void exchange(T[] array, int i, int j) {
        T temporary = array[j];
        array[j] = array[i];
        array[i] = temporary;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; ++i) {
            if (!less(array, i, i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> boolean less(T[] array, int i, int j) {
        return array[i].compareTo(array[j]) < 0;
    }

    public static <T extends Comparable<T>> boolean greater(T[] array, int i, int j) {
        return array[i].compareTo(array[j]) > 0;
    }

    public static Integer[] generate(long size, int min, int max) {
       return Arrays.stream(new Random().ints(size, min, max + 1).toArray()).boxed().toArray(Integer[]::new);
    }

    public static Double[] generate(long size, double min, double max) {
        return Arrays.stream(new Random().doubles(size, min, max + 1).toArray()).boxed().toArray(Double[]::new);
    }

}
