package com.heatwave.leetcode.contest.weekly._147;

public class _1138AlphabetBoardPath {
    static class Solution {
        public String alphabetBoardPath(String target) {
            StringBuilder ans = new StringBuilder();

            int startX = 0;
            int startY = 0;

            for (char c : target.toCharArray()) {
                int targetX = (c - 'a') / 5;
                int targetY = (c - 'a') % 5;

                while (startX != targetX || startY != targetY) {
                    while (targetX > startX) {
                        if (isValidPos(startX + 1, startY)) {
                            startX += 1;
                            ans.append("D");
                        } else {
                            break;
                        }
                    }

                    while (targetX < startX) {
                        if (isValidPos(startX - 1, startY)) {
                            startX -= 1;
                            ans.append("U");
                        } else {
                            break;
                        }
                    }

                    while (targetY > startY) {
                        if (isValidPos(startX, startY + 1)) {
                            startY += 1;
                            ans.append("R");
                        } else {
                            break;
                        }
                    }

                    while (targetY < startY) {
                        if (isValidPos(startX, startY - 1)) {
                            startY -= 1;
                            ans.append("L");
                        } else {
                            break;
                        }
                    }
                }

                ans.append("!");
            }

            return ans.toString();
        }

        private boolean isValidPos(int x, int y) {
            if (x < 0 || y < 0) {
                return false;
            }
            if (x > 5 || y > 4) {
                return false;
            }

            if (x == 5 && y > 0) {
                return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.alphabetBoardPath("zdz");
    }
}
