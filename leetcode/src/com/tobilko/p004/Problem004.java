package com.tobilko.p004;


import java.util.Arrays;

public class Problem004 {

    public static void main(String[] args) {
        System.out.println(new Problem004().findMedianSortedArrays(
//                new int[]{1, 3, 8, 14, 20, 21, 30},
//                new int[]{5, 11, 12, 14, 22, 32, 32, 33}
                new int[]{}, new int[] {}
        ));
    }

    public double findMedianSortedArrays(int[] firstArray, int[] secondArray) {
        int m = firstArray.length;
        int n = secondArray.length;

        System.out.println("The first array = " + Arrays.toString(firstArray) + ", the length (m) = " + m);
        System.out.println("The second array = " + Arrays.toString(secondArray) + ", the length (n) = " + n);

        double median = 0;

        if (m == 0 || n == 0) {

            if (m == 0 && n == 0) {
                System.out.println("Both arrays are empty. Returning 0...");
            } else if (m == 0) {
                System.out.println("The first array is empty. Calculating a median within the second array...");
                median = findMedianWithinArray(secondArray);
            } else {
                System.out.println("The second array is empty. Calculating a median within the first array...");
                median = findMedianWithinArray(firstArray);
            }
            return median;
        }

        return m >= n ?
                (median = findMedianSortedArray(firstArray, secondArray)) == -1 ? findMedianSortedArray(secondArray, firstArray) : median :
                (median = findMedianSortedArray(secondArray, firstArray)) == -1 ? findMedianSortedArray(firstArray, secondArray) : median;
    }

    private double findMedianWithinArray(int[] array) {
        return array.length % 2 == 0 ?
                findMedianWithinArrayWithEvenElementNumber(array) :
                findMedianWithinArrayWithOddElementNumber(array);
    }

    private double findMedianWithinArrayWithEvenElementNumber(int[] array) {
        System.out.println("Finding a median index for the even length...");

        int n = array.length;
        return (array[n / 2] + array[(n - 1) / 2]) / 2.;
    }

    private double findMedianWithinArrayWithOddElementNumber(int[] array) {
        System.out.println("Finding a median index for the odd length...");

        return array[(array.length - 1) / 2];
    }

    private double findMedianSortedArray(int[] array1, int[] array2) {
        int m = array1.length;
        int n = array2.length;
        System.out.println("m = " + m + ", n = " + n);

        int medianIndexGuess = (m - 1) / 2;
        System.out.println("g = " + medianIndexGuess + ", array[g] = " + array1[medianIndexGuess]);

        int l = m + n;
        System.out.println("total l = " + l);

        int tGreaterMedianGuess = (l - 1) / 2;
        int mGreaterMedianGuess = m - medianIndexGuess - 1;
        int nGreaterMedianGuess = tGreaterMedianGuess - mGreaterMedianGuess + 1;
        System.out.println("n > in a+b = " + tGreaterMedianGuess);
        System.out.println("n > in a = " + mGreaterMedianGuess);
        System.out.println("n > in b = " + nGreaterMedianGuess);

        // todo

        return 0.;
    }

}