package com.tobilko.g;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrew Tobilko on 11/30/17.
 */
public final class G1 {

    @Test
    public void testGettingFirstRecurringString() {
        final Function<String, Character> getFirstRecurringChar = this::getFirstRecurringChar;

        assertEquals(Character.valueOf('B'), getFirstRecurringChar.apply("BADCBA"));
        assertEquals(Character.valueOf('B'), getFirstRecurringChar.apply("BBBBBB"));
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

        assertEquals(Character.valueOf('B'), getFirstRecurringChar2.apply("BADCBA"));
        assertEquals(Character.valueOf('B'), getFirstRecurringChar2.apply("BBBBBB"));
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

        // TODO: 12/1/17
    }

    private Character getFirstNonRecurringChar(String string) {
        // TODO: 12/1/17
        return null;
    }

}
