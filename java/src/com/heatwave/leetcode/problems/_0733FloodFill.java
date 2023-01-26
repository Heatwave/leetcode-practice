package com.heatwave.leetcode.problems;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * <p>
 * Return the modified image after performing the flood fill.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * Example 2:
 * <p>
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 * Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 *  
 * <p>
 * Constraints:
 * <p>
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], color < 216
 * 0 <= sr < m
 * 0 <= sc < n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0733FloodFill {
    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int[][] checked = new int[image.length][image[0].length];
            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[0].length; j++) {
                    checked[i][j] = 0;
                }
            }
            recursiveFill(image, image[sr][sc], checked, sr, sc, color);
            return image;
        }

        private void recursiveFill(int[][] image, int originColor, int[][] checked, int sr, int sc, int color) {
            if (checked[sr][sc] == 1) {
                return;
            }
            checked[sr][sc] = 1;
            if (image[sr][sc] != originColor) {
                return;
            }
            image[sr][sc] = color;
            if (sr - 1 >= 0) {
                recursiveFill(image, originColor, checked, sr - 1, sc, color);
            }
            if (sc - 1 >= 0) {
                recursiveFill(image, originColor, checked, sr, sc - 1, color);
            }
            if (sr + 1 < image.length) {
                recursiveFill(image, originColor, checked, sr + 1, sc, color);
            }
            if (sc + 1 < image[0].length) {
                recursiveFill(image, originColor, checked, sr, sc + 1, color);
            }
        }
    }
}
