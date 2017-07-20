package com.tobilko.sorting.heap.utils;

public class BinaryHeapUtils {

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
