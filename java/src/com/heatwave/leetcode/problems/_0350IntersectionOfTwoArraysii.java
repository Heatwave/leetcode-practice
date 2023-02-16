package com.heatwave.leetcode.problems;

import java.util.*;

public class _0350IntersectionOfTwoArraysii {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> ans = new LinkedList<>();
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

    class SolutiuonHashMap {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> ans = new LinkedList<>();

            Map<Integer, Integer> map = new HashMap<>();
            int n = nums1.length, m = nums2.length;
            int[] longer, shorter;
            if (n > m) {
                longer = nums1;
                shorter = nums2;
            } else {
                longer = nums2;
                shorter = nums1;
            }

            for (int i : shorter) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            for (int i : longer) {
                Integer count = map.get(i);
                if (count != null && count != 0) {
                    ans.add(i);
                    map.put(i, count - 1);
                }
            }

            return ans.stream().mapToInt(Integer::valueOf).toArray();
        }
    }

    class SolutionDoublePoint {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> ans = new ArrayList<>();
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
