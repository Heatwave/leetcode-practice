package com.heatwave.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0047Permutationsii {
    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            backtracking(nums, used);
            return ans;
        }

        private void backtracking(int[] nums, boolean[] used) {
            if (temp.size() == nums.length) {
//                System.out.println("add " + temp + " to ans");
                ans.add(new ArrayList<>(temp));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
//                    System.out.println(i + " used continue");
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
//                    System.out.println(i + " duplicate continue");
                    continue;
                }
//                System.out.println("current temp: " + temp + " add " + nums[i] + " to temp");
                temp.add(nums[i]);
                used[i] = true;
                backtracking(nums, used);
//                System.out.println("current temp: " + temp + " remove " + temp.get(temp.size() - 1) + " from temp");
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        solution.permuteUnique(nums);
    }
}
