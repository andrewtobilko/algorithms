package com.tobilko.sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Andrew Tobilko on 12/9/17.
 */
public class QuickSortTest {

    @Test
    public void test() {
        int[] array = new int[] {23, 2, 2, -23, 213, 12};
        System.out.println("before = " + Arrays.toString(array));
        new QuickSort().sort(array, 0, array.length - 1);
        System.out.println("after = " + Arrays.toString(array));
    }

}
