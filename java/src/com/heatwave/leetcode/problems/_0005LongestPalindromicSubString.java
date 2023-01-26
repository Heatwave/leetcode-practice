package com.heatwave.leetcode.problems;

public class _0005LongestPalindromicSubString {
    static class Solution {
        public String longestPalindrome(String s) {
            int windowLength = s.length();
            while (windowLength > 0) {
                int left = 0, right = left + windowLength;
                while (right <= s.length()) {
                    String substring = s.substring(left, right);
                    if (isPalindrome(substring)) {
                        return substring;
                    }
                    left++;
                    right++;
                }
                windowLength--;
            }
            return "";
        }

        private boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    static class SolutionExpandFromCenter {
        public String longestPalindrome(String s) {
            String longest = "";
            for (int i = 0; i < s.length(); i++) {
                String palindrome = palindrome(s, i, i);
                if (palindrome.length() > longest.length()) {
                    longest = palindrome;
                }
                if (i > 0) {
                    palindrome = palindrome(s, i - 1, i);
                    if (palindrome.length() > longest.length()) {
                        longest = palindrome;
                    }
                }
                if (palindrome.length() == s.length()) {
                    return palindrome;
                }
            }
            return longest;
        }

        private String palindrome(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }
    }

    static class SolutionDP {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];

            String ans = "";

            for (int k = 0; k < n; k++) {
                for (int i = 0, j = k; i < n && j < n; i++, j++) {
                    if (i == j) {
                        dp[i][j] = true;
                    } else if (j - i == 1) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else if (i + 1 < n && j - 1 >= 0 && dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }

                    if (dp[i][j] == true) {
                        String sub = s.substring(i, j + 1);
                        if (sub.length() > ans.length()) {
                            ans = sub;
                            if (ans.length() == n) {
                                return ans;
                            }
                        }
                    }
                }
            }

            return ans;
        }
    }
}
