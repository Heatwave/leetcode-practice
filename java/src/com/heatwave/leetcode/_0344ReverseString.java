package com.heatwave.leetcode;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0344ReverseString {
    static class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            char temp;
            while (left < right) {
                temp = s[right];
                s[right] = s[left];
                s[left] = temp;
                left++;
                right--;
            }
        }
    }
}
