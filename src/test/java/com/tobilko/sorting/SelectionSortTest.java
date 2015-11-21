package com.tobilko.sorting;

import com.tobilko.Assistant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrew Tobilko
 */
public class SelectionSortTest {
    @Test
    public void test() throws Exception {
        Integer[] array = Assistant.generate(Byte.MAX_VALUE, Integer.MIN_VALUE / 2, Integer.MAX_VALUE / 2);
        assertEquals("The array has already been sorted.", false, Assistant.isSorted(array));
        Assistant.show(array);
        SelectionSort.sort(array);
        Assistant.show(array);
    }
}
