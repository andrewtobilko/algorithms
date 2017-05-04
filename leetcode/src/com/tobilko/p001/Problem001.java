package com.tobilko.p001;

import java.util.Arrays;

public class Problem001 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem001().twoSum(new int[]{-1, -2, -3, -4, -5}, -8)));
    }

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;

        for (int i = 0; i < length; ++i) {
            int num = nums[i];

            for (int j = i + 1; j < length; ++j) {
                if (num + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }

        return new int[0];
    }

}
