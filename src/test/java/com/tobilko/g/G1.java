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
        final Function<String, Character> function = this::getFirstRecurringString;

        assertEquals(function.apply("BADCBA"), Character.valueOf('B'));
        assertEquals(function.apply("BBBBBB"), Character.valueOf('B'));
        assertEquals(function.apply("ABCDEF"), null);
        assertEquals(function.apply(""), null);
    }

    private Character getFirstRecurringString(String string) {
        final int length = string.length();

        if (length == 0) {
            return null;
        }

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
        final Function<String, Character> function = this::getFirstRecurringString2;

        assertEquals(function.apply("BADCBA"), Character.valueOf('B'));
        assertEquals(function.apply("BBBBBB"), Character.valueOf('B'));
        assertEquals(function.apply("ABCDEF"), null);
        assertEquals(function.apply(""), null);
    }

    private Character getFirstRecurringString2(String string) {
        final int length = string.length();

        if (length == 0) {
            return null;
        }

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

}
