package com.tobilko.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by Andrew Tobilko on 11/25/17.
 */
public final class WeakReferenceTest {

    public static void main(String[] args) {
        Object referent = new Object();
        final ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        final WeakReference weakReference = new WeakReference<>(referent, referenceQueue);

        final Reference<?> refBefore = referenceQueue.poll();

        System.out.println("before " + weakReference.get() + " " + (refBefore != null));

        double[][][] arr = new double[100][100][100];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[j].length; k++) {
                    arr[i][j][k] = Double.MAX_VALUE;
                }
            }
        }
        System.gc();
        System.out.println("after " + weakReference.get());

    }

}
