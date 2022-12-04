package com.heatwave.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * <p>
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 * <p>
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *  
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0994RottingOranges {
    static class Solution {
        public int orangesRotting(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

            int ans = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new Pair<>(i - 1, j));
                        queue.add(new Pair<>(i + 1, j));
                        queue.add(new Pair<>(i, j - 1));
                        queue.add(new Pair<>(i, j + 1));
                    }
                }
            }

            while (!queue.isEmpty()) {
                ans++;
                int size = queue.size();
                while (size-- > 0) {
                    Pair<Integer, Integer> pair = queue.remove();
                    if (pair.first < 0 || pair.second < 0 || pair.first >= m || pair.second >= n) {
                        continue;
                    }
                    int current = grid[pair.first][pair.second];
                    if (current == 0 || current == 2) {
                        continue;
                    }
                    grid[pair.first][pair.second] = 2;
                    queue.add(new Pair<>(pair.first - 1, pair.second));
                    queue.add(new Pair<>(pair.first + 1, pair.second));
                    queue.add(new Pair<>(pair.first, pair.second - 1));
                    queue.add(new Pair<>(pair.first, pair.second + 1));
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }

            return ans == 0 ? 0 : ans - 1;
        }

        static class Pair<T, U> {

            public Pair(T first, U second) {
                this.second = second;
                this.first = first;
            }

            public final T first;
            public final U second;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        solution.orangesRotting(grid);
    }
}
