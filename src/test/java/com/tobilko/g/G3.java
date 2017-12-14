package com.tobilko.g;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

/**
 * Created by Andrew Tobilko on 12/8/17.
 */
public final class G3 {

    @Test
    public void test() {
        final int[] array = {2, 3, 4, 5, 6, 7, 8};
        System.out.println("before = " + Arrays.toString(array));
        shuffleArrayRandomly1(array);
        System.out.println("after = " + Arrays.toString(array));
    }

    private void shuffleArrayRandomly1(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        final int length = array.length;
        final Random random = new Random();

        for (int i = 0; i < length; i++) {
            swapInArrayByIndices(array, i, (int) Math.floor(random.nextDouble()));
        }
    }

    private void swapInArrayByIndices(int[] array, int i, int j) {
        final int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void shuffleArrayRandomly2(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        final int length = array.length;
        final Random random = new Random();

        final double[] randomlyGeneratedArray = new double[length];

        for (int i = 0; i < length; i++) {
            randomlyGeneratedArray[i] = random.nextDouble();
        }
    }

}
