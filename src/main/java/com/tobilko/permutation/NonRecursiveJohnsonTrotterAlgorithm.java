package com.tobilko.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * We assume that directions are specified by boolean values.
 *
 * -> = the right direction = true
 * <- = the left direction = false
 *
 */
public class NonRecursiveJohnsonTrotterAlgorithm {

    public static void main(String[] args) {
        NonRecursiveJohnsonTrotterAlgorithm instance = new NonRecursiveJohnsonTrotterAlgorithm();

        int n = 3;
        List<int[]> permutations = instance.generatePermutations(n);

        System.out.println("permutations.size = " + permutations.size());
        System.out.println("permutations = " + permutations);
    }

    public List<int[]> generatePermutations(int n) {

        // 1. generate an array of values
        int[] values = IntStream.range(0, n).toArray();

        // 2. generate the default direction <- for each value
        boolean[] directions = new boolean[n];

        // 3. generate a resulted list
        List<int[]> permutations = new ArrayList<>();

        boolean isAnyMovable = true;
        while (isAnyMovable) {

            int highestMovableIndex = -1;
            // check out if there is any movable starting from the end
            for (int i = n - 1; i >= 0; --i) {
                if (isMovable(i, values, directions)) {
                    highestMovableIndex = i;
                    break;
                }
            }

            // no movable found
            if (highestMovableIndex == -1) {
                isAnyMovable = false;
            }

            // change directions for all elements that are greater than the current one
            for (int i = 0; i < n; ++i) {
                if (values[i] > values[highestMovableIndex]) {
                    directions[i] = !directions[i];
                }
            }
            move(highestMovableIndex, highestMovableIndex + (directions[highestMovableIndex] ? 1 : -1), values);

            int[] ints = Arrays.copyOf(values, values.length);
            System.out.println(Arrays.toString(ints));
            permutations.add(ints);
        }

        return permutations;
    }

    private boolean isMovable(int index, int[] values, boolean[] directions) {
        int size = values.length;

        if (!isIn(index, 0, size - 1)) {
            return false;
        }

        int neighborIndex = index + (directions[index] ? 1 : -1);
        if (isIn(neighborIndex, 0, size - 1) && values[index] > values[neighborIndex]) {
            return true;
        }

        return false;
    }

    private void move(int i, int j, int[] values) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    private boolean isIn(int index, int lowerBound, int upperBound) {
        return index >= lowerBound && index <= upperBound;
    }


}
