package com.tobilko.sorting.heap;

import java.util.stream.IntStream;

public class HeapSort {

    /**
     * Builds a heap from an array in O(n) operations.
     */
    private <T extends Comparable<T>> void heapify(T[] array) {
        BinaryHeap<T> heap = BinaryHeap.buildFromArray(array);

        System.out.println(heap.toString());
        System.out.println("height = " + heap.getHeight());
    }

    private <T extends Comparable<T>> T[] sort(T[] input) {
        heapify(input);
        return null;
    }

    public static void main(String[] args) {
        new HeapSort().sort(IntStream.of(1, 9, 7, 4, 3).boxed().toArray(Integer[]::new));
    }

}
