package com.heatwave.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0567PermutationInString {
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> charMap = new HashMap<>();
            for (char c : s1.toCharArray()) {
                charMap.merge(c, 1, Integer::sum);
            }

            int left = 0, right = 0;
            char[] chars = s2.toCharArray();
            while (left < chars.length) {
                if (charMap.containsKey(chars[left])) {
                    Map<Character, Integer> newCharMap = new HashMap<>(charMap);
                    right = left;
                    while (right < chars.length) {
                        char c = chars[right];
                        Integer integer = newCharMap.get(c);
                        if (integer == null) {
                            break;
                        } else if (integer - 1 == 0) {
                            newCharMap.remove(c);
                        } else {
                            newCharMap.put(c, integer - 1);
                        }
                        right++;
                    }
                    if (newCharMap.isEmpty()) {
                        return true;
                    }
                }
                left++;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        boolean res = solution.checkInclusion("oooo", "eidbaooo");
//        System.out.println(res);
        boolean res = solution.checkInclusion("hello", "ooolleoooleh");
        System.out.println(res);
    }
}
