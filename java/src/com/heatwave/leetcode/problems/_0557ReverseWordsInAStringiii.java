package com.heatwave.leetcode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 * <p>
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0557ReverseWordsInAStringiii {
    static class Solution {
        public String reverseWords(String s) {
            return Arrays.stream(s.split(" "))
                    .map(StringBuilder::new)
                    .map(StringBuilder::reverse)
                    .collect(Collectors.joining(" "));
        }
    }
}
