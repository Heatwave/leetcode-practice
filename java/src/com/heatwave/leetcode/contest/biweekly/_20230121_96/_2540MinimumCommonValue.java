package com.heatwave.leetcode.contest.biweekly._20230121_96;

public class _2540MinimumCommonValue {
    static class Solution {
        public int getCommon(int[] nums1, int[] nums2) {
            int n = nums1.length, m = nums2.length;
            int left = 0, right = 0;
            while (left < n && right < m && nums1[left] != nums2[right]) {
                int l = nums1[left], r = nums2[right];
                if (l > r) {
                    right++;
                } else {
                    left++;
                }
            }
            if (left < n && right < m && nums1[left] == nums2[right]) {
                return nums1[left];
            }
            return -1;
        }
    }
}
