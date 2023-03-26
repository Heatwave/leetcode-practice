package com.heatwave.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class _0217ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                if (!set.add(num)) {
                    return true;
                }
            }

            return false;
        }
    }
}
