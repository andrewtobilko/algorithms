package com.tobilko.g;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrew Tobilko on 12/7/17.
 */
public final class G2 {

    @Test
    public void test() {
        System.out.println(getLongestConsecutiveChars("AABBCDDBBBEA"));
    }
    // AABCDDBBBEA
    private Map<Character, Integer> getLongestConsecutiveChars(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }

        final Map<Character, Integer> result = new HashMap<>();
        final int length = string.length();

        for (int i = 1; i < length; ++i) {
            final char currentChar = string.charAt(i);

            result.put(currentChar, currentChar == string.charAt(i - 1) ? (result.get(currentChar) != null ? result.get(currentChar) + 1 : 2) : result.get(currentChar));

        }


        return result;
    }

}
