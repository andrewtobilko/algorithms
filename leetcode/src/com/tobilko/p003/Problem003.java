package com.tobilko.p003;

import java.util.LinkedHashSet;
import java.util.Set;

public class Problem003 {

    public static void main(String[] args) {
        System.out.println(new Problem003().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (isPreconditionFailed(s)) {
            return 0;
        }

        Set<Integer> set = new LinkedHashSet<>();

        int lengthOfLongestSubstring = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            int value = chars[i];

            if (!set.add(value)) {
                lengthOfLongestSubstring = recalculateLongestSubstringLength(set, lengthOfLongestSubstring);
                int index = i;
                do {
                    --i;
                }
                while (chars[index] != chars[i]);
            }
        }

        return recalculateLongestSubstringLength(set, lengthOfLongestSubstring);
    }

    private boolean isPreconditionFailed(String s) {
        return s == null || s.isEmpty();
    }

    private int recalculateLongestSubstringLength(Set<Integer> set, int currentLength) {
        int size = set.size();

        if (size > currentLength) {
            currentLength = size;
        }
        set.clear();

        return currentLength;
    }

}
