package com.tobilko.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Andrew Tobilko on 12/9/17.
 */
public class QuickSortTest {

    @Test
    public void test() {
        int[] A = new int[] {23, 2, 2, -23, 213, 12};
        final int[] B = Arrays.copyOf(A, A.length);

        new QuickSort().sort(A, 0, A.length - 1);
        Arrays.sort(B);

        Assert.assertArrayEquals(B, A);
    }

}
