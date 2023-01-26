package com.heatwave.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0036ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                list.add(0);
            }
            rowMap.put(i, list);
        }

        Map<Integer, List<Integer>> colMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                list.add(0);
            }
            colMap.put(i, list);
        }

        Map<Integer, List<Integer>> cubeMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                list.add(0);
            }
            cubeMap.put(i, list);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = Integer.parseInt(String.valueOf(board[i][j]));
                Integer count = rowMap.get(i).get(num - 1);
                rowMap.get(i).set(num - 1, count + 1);

                count = colMap.get(j).get(num - 1);
                colMap.get(j).set(num - 1, count + 1);

                int cubeSeq;
                if (j < 3) {
                    if (i < 3) {
                        cubeSeq = 0;
                    } else if (i < 6) {
                        cubeSeq = 1;
                    } else {
                        cubeSeq = 2;
                    }
                } else if (j < 6) {
                    if (i < 3) {
                        cubeSeq = 3;
                    } else if (i < 6) {
                        cubeSeq = 4;
                    } else {
                        cubeSeq = 5;
                    }
                } else {
                    if (i < 3) {
                        cubeSeq = 6;
                    } else if (i < 6) {
                        cubeSeq = 7;
                    } else {
                        cubeSeq = 8;
                    }
                }

                count = cubeMap.get(cubeSeq).get(num - 1);
                cubeMap.get(cubeSeq).set(num - 1, count + 1);
            }
        }

        boolean res = true;
        for (List<Integer> list : rowMap.values()) {
            for (Integer count : list) {
                if (count > 1) {
                    res = false;
                    break;
                }
            }
        }

        for (List<Integer> list : colMap.values()) {
            for (Integer count : list) {
                if (count > 1) {
                    res = false;
                    break;
                }
            }
        }

        for (List<Integer> list : cubeMap.values()) {
            for (Integer count : list) {
                if (count > 1) {
                    res = false;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean res = isValidSudoku(board);
        System.out.println(res);
    }
}
