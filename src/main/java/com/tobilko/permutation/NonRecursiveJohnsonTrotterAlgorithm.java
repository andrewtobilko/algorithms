package com.tobilko.permutation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NonRecursiveJohnsonTrotterAlgorithm {

    private final boolean LEFT_DIRECTION = false;
    private final boolean RIGHT_DIRECTION = true;

    public static void main(String[] args) {
        NonRecursiveJohnsonTrotterAlgorithm instance = new NonRecursiveJohnsonTrotterAlgorithm();

        int n = 10;
        int[] permutations = instance.generatePermutations(n);

        System.out.println("permutations.size = " + permutations.length);
        System.out.println("permutations = " + Arrays.toString(permutations));
    }

    public int[] generatePermutations(int n) {

        // 1. generate an array of values
        int[] values = IntStream.range(0, n).toArray();

        // 2. generate the default direction <- for each value
        boolean[] directions = new boolean[n];

        for (int i = 0; i < n; i++) {
            System.out.println(isMovable(i, values, directions));
        }


        return new int[0];
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

    private boolean isIn(int index, int lowerBound, int upperBound) {
        return index >= lowerBound && index <= upperBound;
    }



}
