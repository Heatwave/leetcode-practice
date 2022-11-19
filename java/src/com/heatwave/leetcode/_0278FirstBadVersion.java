package com.heatwave.leetcode;

public class _0278FirstBadVersion {
    static class Solution {
        public int firstBadVersion(int n) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (isBadVersion(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public boolean isBadVersion(int version) {
            return version >= 1702766719;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int res = solution.firstBadVersion(2126753390);
            System.out.println(res);
        }
    }
}
