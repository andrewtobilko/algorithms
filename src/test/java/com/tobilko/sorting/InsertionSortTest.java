package com.tobilko.sorting;

import com.tobilko.Assistant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrew Tobilko
 */
public class InsertionSortTest {
    @Test
    public void test() throws Exception {
        Long[] array = Assistant.generate(Byte.MAX_VALUE, Long.MIN_VALUE / 2, Long.MAX_VALUE / 2);
        assertEquals("The array has already been sorted.", false, Assistant.isSorted(array));
        Assistant.show(array);
        InsertionSort.sort(array);
        Assistant.show(array);
    }
}
