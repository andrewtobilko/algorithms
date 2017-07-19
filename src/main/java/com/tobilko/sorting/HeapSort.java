package com.tobilko.sorting;

public class HeapSort {

    /**
     *
     * Builds a heap from an array in O(n) operations.
     *
     */
    private <T extends Comparable<T>> void heapify(T[] array) {

    }

    private <T extends Comparable<T>> T[] sort(T[] input) {
        Heap<T> heap = Heap.buildFromArray(input);

        return null;
    }

}

class Heap<T extends Comparable<T>> {

    private T[] array;

    private Heap(T[] array) {
        this.array = convertToHeapInternalArray(array);
    }

    private <T> T[] convertToHeapInternalArray(T[] array) {
        return array;
    }

    public static <T extends Comparable<T>> Heap<T> buildFromArray(T[] array) {
        return new Heap<>(array);
    }

}