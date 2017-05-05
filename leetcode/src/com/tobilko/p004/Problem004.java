package com.tobilko.p004;


public class Problem004 {

    public static void main(String[] args) {
        new Problem004().findMedianSortedArrays(new int[]{1, 3, 5, 5}, new int[]{2});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0) {
            if (n == 0) {
                System.out.println("nums1 and nums2 are both 0-length arrays.");
                return -1;
            }
            System.out.println("nums1 is a 0-length array.");
            return findMedianIntoSortedArray(nums2, nums1);
        }

        if (n == 0) {
            System.out.println("nums2 is a 0-length array.");
            return findMedianIntoSortedArray(nums1, nums2);
        }

        double result = -1;

        return m >= n ?
                (result = findMedianIntoSortedArray(nums1, nums2)) == -1 ? findMedianIntoSortedArray(nums2, nums1) : result :
                (result = findMedianIntoSortedArray(nums2, nums1)) == -1 ? findMedianIntoSortedArray(nums1, nums2) : result;
    }

    private double findMedianIntoSortedArray(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        for (int low = 0, high = m; low < high; ) {
            int guess = low + high / 2;

            int totalLength = m + n;
            int median = (totalLength - 1) / 2; // todo

            int numberElementsGreaterGuess = (totalLength - 1) - median;
            int numberNums1ElementsGreaterGuess = n - guess;
            int numberNums2ElementsGreaterGuess = numberElementsGreaterGuess - numberNums1ElementsGreaterGuess;

        }

        return -1;
    }

    private int getMedianIndex(int[] arr) {
        int length = arr.length;
        return length % 2 == 0 ? getMedianIndexForEvenSequence(length) : getMedianIndexForOddSequence(length);
    }

    private int getMedianIndexForOddSequence(int n) {
        return (n - 1) / 2;
    }

    private int getMedianIndexForEvenSequence(int n) {
        return (int)Math.floor(getMedianIndexForOddSequence(n));
    }

}
