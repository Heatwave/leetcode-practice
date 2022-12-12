package com.heatwave.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0090SubSetsii {
    static class Solution {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtracking(nums, 0);
            return ans;
        }

        private void backtracking(int[] nums, int index) {
            ans.add(new ArrayList<>(temp));

            for (int i = index; i < nums.length; i++) {
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                backtracking(nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
