package com.heatwave.contest.biweekly._20221210_93;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _6262MaximumStarSumOfAGraph {
    static class Solution {
        public int maxStarSum(int[] vals, int[][] edges, int k) {
            if (vals.length == 1) {
                return vals[0];
            }

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < vals.length; i++) {
                map.put(i, new ArrayList<>());
            }

            for (int[] edge : edges) {
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }

            int max = 0;

            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                int nodeMax = vals[entry.getKey()];

                List<Integer> list = entry.getValue().stream()
                        .map(index -> vals[index])
                        .sorted()
                        .collect(Collectors.toList());
                for (int i = list.size() - 1, j = k; i >= 0 && j > 0; i--, j--) {
                    if (list.get(i) > 0) {
                        nodeMax += list.get(i);
                    }
                }
                max = Math.max(max, nodeMax);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] vals = {1, -8, 0};
        int[] vals = {1, 2, 3, 4, 10, -10, -20};
//        int[][] edges = {{1, 0}, {2, 1}};
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}};
        solution.maxStarSum(vals, edges, 2);
    }
}
