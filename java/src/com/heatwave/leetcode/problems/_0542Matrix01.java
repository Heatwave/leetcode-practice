package com.heatwave.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 * <p>
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *  
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0542Matrix01 {
    static class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;

            int[][] newMat = new int[m][n];

            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        queue.add(new Pair<>(i - 1, j));
                        queue.add(new Pair<>(i + 1, j));
                        queue.add(new Pair<>(i, j - 1));
                        queue.add(new Pair<>(i, j + 1));
                    }
                }
            }

            int currentDistance = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Pair<Integer, Integer> pair = queue.remove();
                    if (pair.first < 0 || pair.second < 0 || pair.first >= m || pair.second >= n) {
                        continue;
                    }
                    if (mat[pair.first][pair.second] == 0) {
                        newMat[pair.first][pair.second] = 0;
                        continue;
                    }
                    if (newMat[pair.first][pair.second] != 0) {
                        continue;
                    }
                    newMat[pair.first][pair.second] = currentDistance;
                    queue.add(new Pair<>(pair.first - 1, pair.second));
                    queue.add(new Pair<>(pair.first + 1, pair.second));
                    queue.add(new Pair<>(pair.first, pair.second - 1));
                    queue.add(new Pair<>(pair.first, pair.second + 1));
                }
                currentDistance++;
            }

            return newMat;
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

    static class SolutionDP {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;

            int[][] newMat = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newMat[i][j] = 999999;
                    if (mat[i][j] == 0) {
                        newMat[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - 1 >= 0) {
                        newMat[i][j] = Math.min(newMat[i][j], newMat[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        newMat[i][j] = Math.min(newMat[i][j], newMat[i][j - 1] + 1);
                    }
                }
            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i + 1 < m) {
                        newMat[i][j] = Math.min(newMat[i][j], newMat[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        newMat[i][j] = Math.min(newMat[i][j], newMat[i][j + 1] + 1);
                    }
                }
            }

            return newMat;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.updateMatrix(mat);
    }
}
