package com.heatwave.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _0349IntersectionOfTwoArrays {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> ans = new HashSet<>();
            Set<Integer> set = new HashSet<>();
            for (int i : nums1) {
                set.add(i);
            }
            for (int i : nums2) {
                if (set.contains(i)) {
                    ans.add(i);
                }
            }
            return ans.stream().mapToInt(Integer::valueOf).toArray();
        }
    }

    class SolutionDoublePoint {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> ans = new HashSet<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int n = nums1.length, m = nums2.length;
            int left = 0, right = 0;

            while (left < n && right < m) {
                int l = nums1[left], r = nums2[right];
                if (l == r) {
                    ans.add(l);
                    left++;
                    right++;
                } else if (l > r) {
                    right++;
                } else {
                    left++;
                }
            }

            return ans.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
}
