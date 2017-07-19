package com.tobilko.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HeapSort {

    /**
     *
     * Builds a heap from an array in O(n) operations.
     *
     */
    private <T extends Comparable<T>> void heapify(T[] array) {
        Heap<T> heap = Heap.buildFromArray(array);

        System.out.println(heap);
    }

    private <T extends Comparable<T>> T[] sort(T[] input) {
        heapify(input);
        return null;
    }

    public static void main(String[] args) {
        new HeapSort().sort(IntStream.of(1, 9, 7, 4, 3).boxed().toArray(Integer[]::new));
    }

}

class Heap<T extends Comparable<T>> {

    private T[] array;

    private Heap(T[] array) {
        this.array = array;
        convertToHeapInternalArray(array);
    }

    private void convertToHeapInternalArray(T[] array) {
        int length = array.length;
        int lastElementIndex = length - 1;

        int startIndex = HeapUtils.getParentIndex(lastElementIndex); // last parent index

        for (;startIndex >= 0; --startIndex) {
            siftDown(startIndex, lastElementIndex);
        }
    }

    public void siftDown(int startIndex, int endIndex) {
        int rootIndex = startIndex;

        while(HeapUtils.getLeftChildIndex(rootIndex) <= endIndex) {
            int leftChildIndex = HeapUtils.getLeftChildIndex(rootIndex);
            int rightChildIndex = leftChildIndex + 1;

            int swapIndex = rootIndex;

            // if the parent is less than the left child
            if (array[swapIndex].compareTo(array[leftChildIndex]) < 0) {
                swapIndex = leftChildIndex;
            }

            // if the parent is greater than the right child
            if (rightChildIndex <= endIndex && array[swapIndex].compareTo(array[rightChildIndex]) < 0) {
                swapIndex = rightChildIndex;
            }

            if (rootIndex == swapIndex) {
                // nothing has changed, the parent is the largest
                return;
            } else {
                swapByIndices(rootIndex, swapIndex);
                rootIndex = swapIndex;
            }

        }
    }

    private void swapByIndices(int firstIndex, int secondIndex) {
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static <T extends Comparable<T>> Heap<T> buildFromArray(T[] array) {
        return new Heap<>(array);
    }

    @Override
    public String toString() {
        return "Heap = " + Arrays.toString(array);
    }

    public String toPrettyString() {
        return "";
    }

}

class HeapUtils {

    public static int getParentIndex(int childIndex) {
        return childIndex / 2;
    }

    public static int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    public static int getRightChildIndex(int parentIndex) {
        return getLeftChildIndex(parentIndex) + 1;
    }

}