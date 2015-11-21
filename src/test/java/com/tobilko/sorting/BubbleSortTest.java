package com.tobilko.sorting;

import com.tobilko.Assistant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrew Tobilko
 */
public class BubbleSortTest {
    @Test
    public void test() throws Exception {
        Double[] array = Assistant.generate(Byte.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE);
        assertEquals("The array has already been sorted.", false, Assistant.isSorted(array));
        Assistant.show(array);
        BubbleSort.sort(array);
        Assistant.show(array);
    }
}
