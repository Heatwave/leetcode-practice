package com.heatwave.leetcode.contest.biweekly._20230107_95;

import java.util.ArrayList;
import java.util.List;

public class _6287CategorizeBoxAccordingToCriteria {
    static class Solution {
        public String categorizeBox(int length, int width, int height, int mass) {
            long volume = (long) length * width * height;

            List<String> list = new ArrayList<>();
            if (length >= 1E4 || width >= 1E4 || height >= 1E4 || volume >= 1E9) {
                list.add("Bulky");
            }
            if (mass >= 100) {
                list.add("Heavy");
            }

            if (list.contains("Bulky") && list.contains("Heavy")) {
                return "Both";
            } else if (list.contains("Bulky")) {
                return "Bulky";
            } else if (list.contains("Heavy")) {
                return "Heavy";
            } else {
                return "Neither";
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.categorizeBox(3223, 1271, 2418, 749);
    }
}
