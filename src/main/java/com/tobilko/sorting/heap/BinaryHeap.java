package com.tobilko.sorting.heap;

import com.tobilko.sorting.heap.utils.BinaryHeapUtils;

import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>> {

    private T[] array;

    private BinaryHeap(T[] array) {
        this.array = array;
        convertToHeapInternalArray(array);
    }

    private void convertToHeapInternalArray(T[] array) {
        int length = array.length;
        int lastElementIndex = length - 1;

        int startIndex = BinaryHeapUtils.getParentIndex(lastElementIndex); // last parent index

        for (;startIndex >= 0; --startIndex) {
            siftDown(startIndex, lastElementIndex);
        }
    }

    private void siftDown(int startIndex, int endIndex) {
        int rootIndex = startIndex;

        while(BinaryHeapUtils.getLeftChildIndex(rootIndex) <= endIndex) {
            int leftChildIndex = BinaryHeapUtils.getLeftChildIndex(rootIndex);
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

    public static <T extends Comparable<T>> BinaryHeap<T> buildFromArray(T[] array) {
        return new BinaryHeap<>(array);
    }

    public long getHeight() {
        return Math.round(Math.log(2 * array.length - 1) / Math.log(2)) - 1;
    }

    @Override
    public String toString() {
        return "Heap = " + Arrays.toString(array);
    }

    public String toPrettyString() {
        return "";
    }

}
