package com.heatwave.leetcode.contest.weekly._20230319_337;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _6352TheNumberOfBeautifulSubsets {
    static class Solution {
        private int ans = 0;

        public int beautifulSubsets(int[] nums, int k) {
            Arrays.sort(nums);
            List<Tuple> invalidTuples = new LinkedList<>();
            for (int num : nums) {
                int index = Arrays.binarySearch(nums, num + k);
                if (index >= 0) {
                    invalidTuples.add(new Tuple(num, nums[index]));
                }
            }

            List<Integer> temp = new LinkedList<>();
            backtracking(nums, 0, temp, invalidTuples);

            return ans;
        }

        private void backtracking(int[] nums, int index, List<Integer> temp, List<Tuple> invalidTuples) {
            boolean beautiful = true;
            if (temp.size() == 0) {
                beautiful = false;
            }
            for (Tuple invalidTuple : invalidTuples) {
                if (temp.contains(invalidTuple.l) && temp.contains(invalidTuple.r)) {
                    beautiful = false;
                    break;
                }
            }

            if (beautiful) {
                ans++;
            }

            for (int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                backtracking(nums, i + 1, temp, invalidTuples);
                temp.remove(temp.size() - 1);
            }
        }

        class Tuple {
            int l;
            int r;

            Tuple(int l, int r) {
                this.l = l;
                this.r = r;
            }

            @Override
            public String toString() {
                return "Tuple{" +
                        "l=" + l +
                        ", r=" + r +
                        '}';
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.beautifulSubsets(new int[]{2, 4, 6}, 2);
    }
}
