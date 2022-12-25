package com.heatwave.leetcode.contest.weekly._20221225_325;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _6269ShortestDistanceToTargetStringInACircularArray {
    static class Solution {
        public int closetTarget(String[] words, String target, int startIndex) {
            Map<String, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                List<Integer> l = map.computeIfAbsent(words[i], s -> new ArrayList<>());
                l.add(i);
            }

            if (!map.containsKey(target)) {
                return -1;
            }

            List<Integer> posList = map.get(target);

            int ans = Integer.MAX_VALUE;

            for (Integer pos : posList) {
                int middle = Math.abs(pos - startIndex);
                if (middle == 0) {
                    return 0;
                }
                int moveRight = Integer.MAX_VALUE, moveLeft = Integer.MAX_VALUE;
                if (pos < startIndex) {
                    moveRight = words.length - startIndex + pos;
                } else {
                    moveLeft = startIndex + (words.length - pos);
                }
                int temp = Math.min(Math.min(moveLeft, moveRight), middle);
                ans = Math.min(ans, temp);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"a", "b", "leetcode"};
//        String[] strings = {"a", "b", "leetcode"};
//        String[] strings = {"hello", "i", "am", "leetcode", "hello"};
        int ans = solution.closetTarget(strings, "leetcade", 0);
//        int ans = solution.closetTarget(strings, "leetcode", 0);
//        int ans = solution.closetTarget(strings, "hello", 1);
        System.out.println(ans);
    }
}
