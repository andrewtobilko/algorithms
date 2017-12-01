package com.tobilko.g;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;

import static java.lang.Character.valueOf;
import static org.junit.Assert.assertEquals;

/**
 * Created by Andrew Tobilko on 11/30/17.
 */
public final class G1 {

    @Test
    public void testGettingFirstRecurringString() {
        final Function<String, Character> getFirstRecurringChar = this::getFirstRecurringChar;

        assertEquals(valueOf('B'), getFirstRecurringChar.apply("BADCBA"));
        assertEquals(valueOf('B'), getFirstRecurringChar.apply("BBBBBB"));
        assertEquals(null, getFirstRecurringChar.apply("ABCDEF"));
        assertEquals(null, getFirstRecurringChar.apply(""));
    }

    private Character getFirstRecurringChar(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }

        final int length = string.length();

        for (int i = 0; i < length; i++) {
            char iChar = string.charAt(i);
            for (int j = i + 1; j < length; j++) {
                final char jChar = string.charAt(j);

                if (jChar == iChar) {
                    return jChar;
                }
            }

        }

        return null;
    }

    @Test
    public void testGettingFirstRecurringString2() {
        final Function<String, Character> getFirstRecurringChar2 = this::getFirstRecurringChar2;

        assertEquals(valueOf('B'), getFirstRecurringChar2.apply("BADCBA"));
        assertEquals(valueOf('B'), getFirstRecurringChar2.apply("BBBBBB"));
        assertEquals(null, getFirstRecurringChar2.apply("ABCDEF"));
        assertEquals(null, getFirstRecurringChar2.apply(""));
    }

    private Character getFirstRecurringChar2(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }

        final int length = string.length();
        final Set<Character> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            char currentChar = string.charAt(i);

            if (set.contains(currentChar)) {
                return currentChar;
            }
            set.add(currentChar);
        }

        return null;
    }

    @Test
    public void testGettingFirstNonRecurringString() {
        final Function<String, Character> getFirstNonRecurringChar = this::getFirstNonRecurringChar;

        assertEquals(null, getFirstNonRecurringChar.apply(""));
        assertEquals(null, getFirstNonRecurringChar.apply(null));

        assertEquals(valueOf('B'), getFirstNonRecurringChar.apply("BAACCDDEEFF"));
        assertEquals(valueOf('A'), getFirstNonRecurringChar.apply("BBACCDDEEFF"));
        assertEquals(null, getFirstNonRecurringChar.apply("BBAACCDDEEFF"));
        assertEquals(valueOf('C'), getFirstNonRecurringChar.apply("ABABC"));
        assertEquals(valueOf('B'), getFirstNonRecurringChar.apply("ABAAAAbC"));
    }

    private Character getFirstNonRecurringChar(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }

        final int length = string.length();
        // iteration order is important
        final Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < length; i++) {
            char currentChar = string.charAt(i);

            // if an element is already in the set, remove it
            if (!set.add(currentChar)) {
                set.remove(currentChar);
            }
        }

        // get the element added first
        final Iterator<Character> iterator = set.iterator();
        return iterator.hasNext() ? iterator.next() : null;
    }

}
